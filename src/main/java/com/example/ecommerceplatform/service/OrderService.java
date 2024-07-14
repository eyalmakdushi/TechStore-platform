package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.model.Order;
import com.example.ecommerceplatform.entity.User;
import com.example.ecommerceplatform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
