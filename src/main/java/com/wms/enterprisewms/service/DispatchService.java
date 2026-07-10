package com.wms.enterprisewms.service;

import com.wms.enterprisewms.dto.DispatchRequest;
import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.entity.InventoryTransaction;
import com.wms.enterprisewms.entity.TransactionType;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DispatchService {

    private final InventoryItemRepository inventoryRepository;
    private final InventoryTransactionService inventoryTransactionService;

    public DispatchService(
            InventoryItemRepository inventoryRepository,
            InventoryTransactionService inventoryTransactionService) {

        this.inventoryRepository = inventoryRepository;
        this.inventoryTransactionService = inventoryTransactionService;
    }

    public InventoryItem dispatchStock(DispatchRequest request) {

        InventoryItem inventory = inventoryRepository
                .findByProductProductIdAndStorageBinBinId(
                        request.getProductId(),
                        request.getBinId())
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found"));

        if (inventory.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        inventory.setQuantity(
                inventory.getQuantity() - request.getQuantity());

        InventoryItem updatedInventory = inventoryRepository.save(inventory);

        InventoryTransaction transaction = new InventoryTransaction(
                updatedInventory,
                TransactionType.DISPATCHED,
                request.getQuantity(),
                LocalDateTime.now()
        );

        inventoryTransactionService.saveTransaction(transaction);

        return updatedInventory;
    }
}