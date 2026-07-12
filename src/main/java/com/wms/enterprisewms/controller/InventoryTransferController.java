package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.dto.TransferRequest;
import com.wms.enterprisewms.service.InventoryTransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class InventoryTransferController {

    private final InventoryTransferService inventoryTransferService;

    public InventoryTransferController(InventoryTransferService inventoryTransferService) {
        this.inventoryTransferService = inventoryTransferService;
    }

    @PostMapping
    public String transferInventory(@RequestBody TransferRequest request) {
        return inventoryTransferService.transferInventory(request);
    }
}