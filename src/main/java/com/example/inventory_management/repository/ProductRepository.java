package com.example.inventory_management.repository;

import com.example.inventory_management.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // No custom method needed since low-stock filtering is done in service
}
