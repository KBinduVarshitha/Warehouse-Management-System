package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductProductIdAndStorageBinBinId(
            Long productId,
            Long binId
    );

}