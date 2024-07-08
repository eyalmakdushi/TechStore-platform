package com.example.ecommerceplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Add any necessary attributes to the model
        model.addAttribute("message", "Welcome to the E-commerce Platform!");
        return "home";  // Ensure this matches the home.html template name
    }
}
