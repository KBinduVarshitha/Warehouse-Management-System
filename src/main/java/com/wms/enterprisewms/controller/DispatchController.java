package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.dto.DispatchRequest;
import com.wms.enterprisewms.entity.InventoryItem;
import com.wms.enterprisewms.service.DispatchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {

    private final DispatchService dispatchService;

    public DispatchController(DispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }

    @PostMapping
    public InventoryItem dispatchStock(@RequestBody DispatchRequest request) {
        return dispatchService.dispatchStock(request);
    }
}