package com.wms.enterprisewms.service;

import com.wms.enterprisewms.entity.InventoryTransaction;
import com.wms.enterprisewms.entity.TransactionType;
import com.wms.enterprisewms.repository.InventoryTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryTransactionService {

    private final InventoryTransactionRepository repository;

    public InventoryTransactionService(InventoryTransactionRepository repository) {
        this.repository = repository;
    }

    public InventoryTransaction saveTransaction(InventoryTransaction transaction) {
        return repository.save(transaction);
    }

    public List<InventoryTransaction> getAllTransactions() {
        return repository.findAllByOrderByTransactionTimeDesc();
    }

    public List<InventoryTransaction> getTransactionsByType(TransactionType transactionType) {
        return repository.findByTransactionTypeOrderByTransactionTimeDesc(transactionType);
    }
}