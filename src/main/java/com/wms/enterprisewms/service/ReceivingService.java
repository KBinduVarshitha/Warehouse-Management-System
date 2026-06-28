package com.wms.enterprisewms.service;

import com.wms.enterprisewms.dto.ReceivingRequest;
import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.entity.Product;
import com.wms.enterprisewms.entity.StorageBin;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import com.wms.enterprisewms.repository.ProductRepository;
import com.wms.enterprisewms.repository.StorageBinRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceivingService {

    private final ProductRepository productRepository;
    private final StorageBinRepository storageBinRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public ReceivingService(ProductRepository productRepository,
                            StorageBinRepository storageBinRepository,
                            InventoryItemRepository inventoryItemRepository) {
        this.productRepository = productRepository;
        this.storageBinRepository = storageBinRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Transactional
    public InventoryItem receiveStock(ReceivingRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        StorageBin storageBin = storageBinRepository.findById(request.getStorageBinId())
                .orElseThrow(() -> new RuntimeException("Storage Bin not found"));

        InventoryItem inventoryItem = inventoryItemRepository
                .findByProductProductIdAndStorageBinBinId(
                        request.getProductId(),
                        request.getStorageBinId())
                .orElse(null);

        if (inventoryItem == null) {
            inventoryItem = new InventoryItem();
            inventoryItem.setProduct(product);
            inventoryItem.setStorageBin(storageBin);
            inventoryItem.setQuantity(request.getQuantity());
        } else {
            inventoryItem.setQuantity(
                    inventoryItem.getQuantity() + request.getQuantity()
            );
        }

        return inventoryItemRepository.save(inventoryItem);
    }
}