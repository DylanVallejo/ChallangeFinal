package com.example.demo.domain.service;

import com.example.demo.domain.Order;
import com.example.demo.domain.Product;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    UUID createOrder(Product product);

    void addProduct(UUID id, Product product);

    void completeOrder(UUID id);

    void deleteProduct(UUID id, UUID productId);
    
    List<Order> findAll();
    
    
    List<Product> findAllProducts();
}
