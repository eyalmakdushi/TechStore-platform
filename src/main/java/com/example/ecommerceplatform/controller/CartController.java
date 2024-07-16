package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.entity.Product;
import com.example.ecommerceplatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId, HttpSession session) {
        Product product = productService.getProductById(productId);
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        double total = cart.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(HttpSession session) {
        // Process payment and clear the cart
        session.removeAttribute("cart");
        return "redirect:/home";
    }
}
