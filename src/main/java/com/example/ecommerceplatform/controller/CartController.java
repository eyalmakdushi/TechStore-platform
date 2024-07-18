package com.example.ecommerceplatform.controller;

import com.example.ecommerceplatform.entity.Cart;
import com.example.ecommerceplatform.entity.Product;
import com.example.ecommerceplatform.service.CartService;
import com.example.ecommerceplatform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public String viewCart(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addToCart(@RequestBody AddToCartRequest request) {
        Product product = productService.getProductById(request.getProductId());
        cartService.addToCart(product);
        return "Product added to cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "checkout";
    }

    private static class AddToCartRequest {
        private Long productId;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }
    }
}
