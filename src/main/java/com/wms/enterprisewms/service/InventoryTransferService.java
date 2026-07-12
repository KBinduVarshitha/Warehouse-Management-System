package com.wms.enterprisewms.service;

import com.wms.enterprisewms.dto.TransferRequest;
import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.entity.InventoryTransaction;
import com.wms.enterprisewms.entity.StorageBin;
import com.wms.enterprisewms.entity.TransactionType;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import com.wms.enterprisewms.repository.StorageBinRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InventoryTransferService {

    private final InventoryItemRepository inventoryItemRepository;
    private final StorageBinRepository storageBinRepository;
    private final InventoryTransactionService inventoryTransactionService;

    public InventoryTransferService(
            InventoryItemRepository inventoryItemRepository,
            StorageBinRepository storageBinRepository,
            InventoryTransactionService inventoryTransactionService) {

        this.inventoryItemRepository = inventoryItemRepository;
        this.storageBinRepository = storageBinRepository;
        this.inventoryTransactionService = inventoryTransactionService;
    }

    @Transactional
    public String transferInventory(TransferRequest request) {

        InventoryItem sourceInventory = inventoryItemRepository
                .findByProductProductIdAndStorageBinBinId(
                        request.getProductId(),
                        request.getSourceBinId())
                .orElseThrow(() -> new RuntimeException("Source inventory not found"));

        if (sourceInventory.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock available.");
        }

        StorageBin destinationBin = storageBinRepository
                .findById(request.getDestinationBinId())
                .orElseThrow(() -> new RuntimeException("Destination bin not found"));

        InventoryItem destinationInventory = inventoryItemRepository
                .findByProductProductIdAndStorageBinBinId(
                        request.getProductId(),
                        request.getDestinationBinId())
                .orElse(null);

        if (destinationInventory == null) {
            destinationInventory = new InventoryItem();
            destinationInventory.setProduct(sourceInventory.getProduct());
            destinationInventory.setStorageBin(destinationBin);
            destinationInventory.setQuantity(0);
        }

        sourceInventory.setQuantity(
                sourceInventory.getQuantity() - request.getQuantity());

        destinationInventory.setQuantity(
                destinationInventory.getQuantity() + request.getQuantity());

        inventoryItemRepository.save(sourceInventory);
        inventoryItemRepository.save(destinationInventory);

        InventoryTransaction transaction = new InventoryTransaction(
                sourceInventory,
                TransactionType.TRANSFER,
                request.getQuantity(),
                LocalDateTime.now());

        inventoryTransactionService.saveTransaction(transaction);

        return "Inventory transferred successfully.";
    }
}