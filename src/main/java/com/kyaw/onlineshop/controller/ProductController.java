package com.kyaw.onlineshop.controller;

import com.kyaw.onlineshop.domain.Product;
import com.kyaw.onlineshop.service.CategoryService;
import com.kyaw.onlineshop.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProductController {

    // private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/product")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "admin/productForm";
    }

    @PostMapping("/product")
    public String process(@Valid Product product, BindingResult br, Model model, RedirectAttributes attributes) {
        if (br.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "admin/productForm";
        }
        productService.create(product);
        attributes.addFlashAttribute("success", true);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("success", model.containsAttribute("success"));
        return "admin/products";
    }

    @GetMapping("/product/{id}")
    public String findProductById(@PathVariable int id, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (null != session) model.addAttribute("cartSize", session.getAttribute("cartSize"));

        model.addAttribute("product", productService.findById(id));
        return "user/product";
    }

    @GetMapping("/home/category/{id}")
    public String showProductsByCategory(@PathVariable int id, Model model) {
        model.addAttribute("products", productService.findProductByCatId(id));
        return "user/products";
    }

}
