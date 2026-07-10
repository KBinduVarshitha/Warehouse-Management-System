package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransactionRepository
        extends JpaRepository<InventoryTransaction, Long> {
}