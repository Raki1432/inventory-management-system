package com.example.inventory_management.controller;

import com.example.inventory_management.model.Product;
import com.example.inventory_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Update a product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Increase stock
    @PostMapping("/{id}/increase")
    public ResponseEntity<Product> increaseStock(@PathVariable String id, @RequestParam int amount) {
        return ResponseEntity.ok(productService.increaseStock(id, amount));
    }

    // Decrease stock
    @PostMapping("/{id}/decrease")
    public ResponseEntity<Product> decreaseStock(@PathVariable String id, @RequestParam int amount) {
        return ResponseEntity.ok(productService.decreaseStock(id, amount));
    }

    // Get low-stock products
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> lowStockProducts() {
        return ResponseEntity.ok(productService.getLowStockProducts());
    }
}
