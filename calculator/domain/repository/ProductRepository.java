package com.example.demo.domain.repository;

//import com.example.demo.domain.Order;
import com.example.demo.domain.Product;

import java.util.List;
//import java.util.Optional;
//import java.util.UUID;

public interface ProductRepository {
//    Optional<Order> findById(UUID id);
//
//    void save(Product product);
    List<Product> findAll();
}
