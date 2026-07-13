package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.entity.InventoryTransaction;
import com.wms.enterprisewms.entity.TransactionType;
import com.wms.enterprisewms.service.InventoryTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class InventoryTransactionController {

    private final InventoryTransactionService service;

    public InventoryTransactionController(InventoryTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryTransaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/type/{type}")
    public List<InventoryTransaction> getTransactionsByType(
            @PathVariable TransactionType type) {
        return service.getTransactionsByType(type);
    }
}