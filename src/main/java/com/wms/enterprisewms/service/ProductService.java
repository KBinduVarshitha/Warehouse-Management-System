package com.wms.enterprisewms.service;

import com.wms.enterprisewms.entity.Product;
import com.wms.enterprisewms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String name){
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }
}