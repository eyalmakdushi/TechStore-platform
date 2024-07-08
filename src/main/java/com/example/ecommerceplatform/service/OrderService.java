package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.entity.Order;
import com.example.ecommerceplatform.entity.User;
import com.example.ecommerceplatform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Service methods
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }
}
