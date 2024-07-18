package com.example.ecommerceplatform.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String sessionId;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    public Cart() {}

    public Cart(User user) {
        this.user = user;
    }

    public Cart(String sessionId) {
        this.sessionId = sessionId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalCost() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
