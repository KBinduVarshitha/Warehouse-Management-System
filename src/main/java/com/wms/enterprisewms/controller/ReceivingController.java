package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.dto.ReceivingRequest;
import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.service.ReceivingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receiving")
public class ReceivingController {

    private final ReceivingService receivingService;

    public ReceivingController(ReceivingService receivingService) {
        this.receivingService = receivingService;
    }

    @PostMapping
    public InventoryItem receiveStock(@RequestBody ReceivingRequest request) {
        return receivingService.receiveStock(request);
    }
}