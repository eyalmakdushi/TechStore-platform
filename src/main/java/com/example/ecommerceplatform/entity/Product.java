package com.example.ecommerceplatform.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String image;

    // Getters and setters
    public double getPrice() {
        return price;
    }
}
