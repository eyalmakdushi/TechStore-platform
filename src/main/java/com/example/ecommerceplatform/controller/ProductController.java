package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        // Fetch product details and add to model
        return "product-details";
    }
}
