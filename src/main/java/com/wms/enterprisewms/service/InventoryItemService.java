package com.wms.enterprisewms.service;

import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public InventoryItem addInventoryItem(InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    public List<InventoryItem> getInventoryReport() {
        return inventoryItemRepository.findAllByOrderByQuantityDesc();
    }

    public List<InventoryItem> getInventoryByWarehouse(Long warehouseId) {
        return inventoryItemRepository.findByStorageBinWarehouseWarehouseId(warehouseId);
    }

    public List<InventoryItem> getLowStockItems(Integer threshold) {
        return inventoryItemRepository.findByQuantityLessThan(threshold);
    }

}