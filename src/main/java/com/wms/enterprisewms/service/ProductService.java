package com.wms.enterprisewms.service;

import com.wms.enterprisewms.entity.Product;
import com.wms.enterprisewms.exception.ResourceNotFoundException;
import com.wms.enterprisewms.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Add Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Search Product
    public List<Product> searchProducts(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    // Get Product By Id
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));
    }

    // Delete Product
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }
}