package com.example.ecommerceplatform.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")  // Changed table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

    // Getters and setters
}
