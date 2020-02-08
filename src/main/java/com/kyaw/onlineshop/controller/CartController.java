package com.kyaw.onlineshop.controller;

import com.kyaw.onlineshop.domain.Cart;
import com.kyaw.onlineshop.domain.Product;
import com.kyaw.onlineshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    private final Cart cart;
    private final ProductService productService;

    public CartController(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable int id, HttpServletRequest request) {
        boolean isExisted = false;

        for (Product p : cart.getCartItems()) {
            if (p.getId() == id) {
                isExisted = true;
            }
        }

        if (!isExisted) {
            cart.addToCart(productService.findById(id));
        }

        HttpSession session = request.getSession();
        session.setAttribute("cartSize", cart.cartSize());
        return "redirect:/product/" + id;
    }

}
