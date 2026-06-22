package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}