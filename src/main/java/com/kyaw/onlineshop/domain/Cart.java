package com.kyaw.onlineshop.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Cart {

    private int cartSize;

    private List<Integer> buyItemsQuantity = new ArrayList<>();

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

        this.cartSize = this.cartItems.size();
        return cartSize;
    }

    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }

    public List<Integer> getBuyItemsQuantity() {
        return buyItemsQuantity;
    }

    public void setBuyItemsQuantity(List<Integer> buyItemsQuantity) {
        this.buyItemsQuantity = buyItemsQuantity;
    }
}
