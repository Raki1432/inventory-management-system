package com.example.inventory_management.dto;

//package com.example.inventory.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String name;
    private String description;
    private int stockQuantity;
    private int lowStockThreshold;
}
