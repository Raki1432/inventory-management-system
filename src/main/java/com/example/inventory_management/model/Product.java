package com.example.inventory_management.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id; // MongoDB uses String for IDs

    private String name;
    private String description;
    private int stockQuantity;
    private int lowStockThreshold;
}
