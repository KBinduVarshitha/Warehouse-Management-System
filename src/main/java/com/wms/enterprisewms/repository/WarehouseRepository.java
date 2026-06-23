package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}