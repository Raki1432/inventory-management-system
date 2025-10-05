package com.example.inventory_management.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String id) {
        super("Insufficient stock for product with id: " + id);
    }
}