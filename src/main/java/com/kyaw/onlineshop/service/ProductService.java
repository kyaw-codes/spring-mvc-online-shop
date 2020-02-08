package com.kyaw.onlineshop.service;

import com.kyaw.onlineshop.domain.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> findAll();

    Product findById(int id);

    List<Product> findProductByCatId(int id);
}
