package com.kyaw.onlineshop.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Product name cannot be empty!")
    private String name;
    private int quantity;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdated;

    @Transient
    private int cartItemQty;

    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(String name, int quantity, double price, LocalDate lastUpdated) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getCartItemQty() {
        return cartItemQty;
    }

    public void setCartItemQty(int cartItemQty) {
        this.cartItemQty = cartItemQty;
    }
}
