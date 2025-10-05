package com.example.inventory_management.service;

import com.example.inventory_management.exception.InsufficientStockException;
import com.example.inventory_management.exception.ProductNotFoundException;
import com.example.inventory_management.model.Product;
import com.example.inventory_management.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // Create product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Get product by ID (String ID for MongoDB)
    public Product getProduct(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Update product
    public Product updateProduct(String id, Product updatedProduct) {
        Product product = getProduct(id);
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setLowStockThreshold(updatedProduct.getLowStockThreshold());
        if (updatedProduct.getStockQuantity() >= 0) {
            product.setStockQuantity(updatedProduct.getStockQuantity());
        }
        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(String id) {
        productRepository.delete(getProduct(id));
    }

    // Increase stock
    public Product increaseStock(String id, int amount) {
        Product product = getProduct(id);
        product.setStockQuantity(product.getStockQuantity() + amount);
        return productRepository.save(product);
    }

    // Decrease stock with validation
    public Product decreaseStock(String id, int amount) {
        Product product = getProduct(id);
        if (product.getStockQuantity() < amount) {
            throw new InsufficientStockException(id);
        }
        product.setStockQuantity(product.getStockQuantity() - amount);
        return productRepository.save(product);
    }

    // Get products below low-stock threshold
    public List<Product> getLowStockProducts() {
        // Using custom repository method
        return productRepository.findAll().stream()
                .filter(p -> p.getStockQuantity() < p.getLowStockThreshold())
                .toList();
    }
}
