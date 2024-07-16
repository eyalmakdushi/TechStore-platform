package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.entity.Product;
import com.example.ecommerceplatform.entity.User;
import com.example.ecommerceplatform.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(User user, Product product) {
        cartRepository.addToCart(user.getId(), product.getId());
    }

    public List<Product> getCartItems(User user) {
        return cartRepository.findCartItemsByUserId(user.getId());
    }

    public double calculateTotalCost(List<Product> cartItems) {
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }

    public void clearCart(User user) {
        cartRepository.clearCart(user.getId());
    }
}
