package com.wms.enterprisewms.repository;

import com.wms.enterprisewms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Product> findBySku(String sku);

    List<Product> findByProductNameContainingIgnoreCaseAndPriceBetween(
            String name,
            Double minPrice,
            Double maxPrice
    );
}