package com.kyaw.onlineshop.service;

import com.kyaw.onlineshop.domain.Category;

import java.util.List;

public interface CategoryService {


    Category create(Category category);

    Category findById(int id);

    List<Category> findAll();

}
