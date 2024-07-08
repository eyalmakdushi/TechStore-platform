package com.example.ecommerceplatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")  // Changed table name
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String product;
    private int quantity;

    // Getters and setters
}
