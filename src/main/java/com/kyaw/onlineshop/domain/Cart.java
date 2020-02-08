package com.kyaw.onlineshop.domain;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Cart {

    private Set<Product> cartItems = new HashSet<>();

    public void addToCart(Product product) {
        cartItems.add(product);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public Set<Product> getCartItems() {
        return new HashSet<>(cartItems);
    }

    public int cartSize() {
        if (cartItems.isEmpty()) return 0;
        return cartItems.size();
    }
}
