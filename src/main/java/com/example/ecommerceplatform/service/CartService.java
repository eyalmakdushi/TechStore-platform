package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.entity.Cart;
import com.example.ecommerceplatform.entity.Product;
import com.example.ecommerceplatform.entity.User;
import com.example.ecommerceplatform.repository.CartRepository;
import com.example.ecommerceplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public void addToCart(String email, Product product) {
        Cart cart;
        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
            cart = cartRepository.findByUser(user).orElse(new Cart(user));
        } else {
            cart = cartRepository.findBySessionId("guest").orElse(new Cart("guest"));
        }
        cart.addProduct(product);
        cartRepository.save(cart);
    }

    public Cart getCart(String email) {
        if (email != null) {
            User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
            return cartRepository.findByUser(user).orElse(new Cart(user));
        } else {
            return cartRepository.findBySessionId("guest").orElse(new Cart("guest"));
        }
    }
}
