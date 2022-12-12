package com.example.demo.domain.repository;

import com.example.demo.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
    List<Order> findAll();
}
