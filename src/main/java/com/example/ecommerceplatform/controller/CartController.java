package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.entity.Cart;
import com.example.ecommerceplatform.entity.Product;
import com.example.ecommerceplatform.service.CartService;
import com.example.ecommerceplatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addToCart(@RequestBody ProductRequest productRequest, Principal principal) {
        String email = (principal != null) ? principal.getName() : null;
        Product product = productService.getProductById(productRequest.getProductId());
        System.out.println("Adding product to cart: " + product.getName()); // Debug print
        cartService.addToCart(email, product);
        return "Product added to cart";
    }

    @GetMapping
    public Cart getCart(Principal principal) {
        String email = (principal != null) ? principal.getName() : null;
        Cart cart = cartService.getCart(email);
        System.out.println("Cart contents: " + cart.getProducts().size() + " items."); // Debug print
        return cart;
    }
}
