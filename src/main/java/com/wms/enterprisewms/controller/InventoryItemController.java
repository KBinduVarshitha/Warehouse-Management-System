package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.service.InventoryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping
    public InventoryItem addInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemService.addInventoryItem(inventoryItem);
    }

    @GetMapping
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemService.getAllInventoryItems();
    }
}