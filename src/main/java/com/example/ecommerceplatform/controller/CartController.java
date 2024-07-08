package com.example.ecommerceplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(Model model) {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Product 1", 1, 10.00));
        cartItems.add(new CartItem("Product 2", 2, 15.00));
        cartItems.add(new CartItem("Product 3", 1, 20.00));

        double totalAmount = cartItems.stream().mapToDouble(CartItem::getTotal).sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", totalAmount);

        return "cart";
    }

    static class CartItem {
        private String productName;
        private int quantity;
        private double price;

        public CartItem(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getTotal() {
            return this.price * this.quantity;
        }
    }
}
