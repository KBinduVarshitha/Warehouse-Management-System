package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}