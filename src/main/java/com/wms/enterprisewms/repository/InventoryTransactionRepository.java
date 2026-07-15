package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.InventoryTransaction;
import com.wms.enterprisewms.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {

    List<InventoryTransaction> findAllByOrderByTransactionTimeDesc();

    List<InventoryTransaction> findByTransactionTypeOrderByTransactionTimeDesc(TransactionType transactionType);

    List<InventoryTransaction> findByTransactionTimeBetween(
            LocalDateTime startDate,
            LocalDateTime endDate);
}