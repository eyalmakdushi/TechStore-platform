package com.example.ecommerceplatform.service;

import com.example.ecommerceplatform.entity.Cart;
import com.example.ecommerceplatform.entity.Product;
import com.example.ecommerceplatform.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart() {
        return cartRepository.findById(1L).orElse(new Cart());
    }

    public void addToCart(Product product) {
        Cart cart = getCart();
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public void checkout(Cart cart) {
        // Implement checkout logic
    }
}
