package com.wms.enterprisewms.controller;

import com.wms.enterprisewms.entity.Product;
import com.wms.enterprisewms.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/paged")
    public Page<Product> getProductsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "productId") String sortBy) {

        return productService.getProductsWithPagination(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }

    @GetMapping("/price")
    public List<Product> getProductsByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/sku/{sku}")
    public Product getProductBySku(@PathVariable String sku) {

        List<Product> products = productService.getProductBySku(sku);

        if (products.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        return products.get(0);
    }

    @GetMapping("/filter")
    public List<Product> filterProducts(
            @RequestParam String name,
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return productService.filterProducts(name, minPrice, maxPrice);
    }

}