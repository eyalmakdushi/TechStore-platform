package com.example.ecommerceplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(Model model) {
        // Add any required attributes to the model
        return "cart";  // This should match the template name cart.html
    }
}
