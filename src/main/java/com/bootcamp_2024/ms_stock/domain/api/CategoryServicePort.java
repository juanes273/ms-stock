package com.bootcamp_2024.ms_stock.domain.api;

import com.bootcamp_2024.ms_stock.domain.model.Category;

import java.util.List;

public interface CategoryServicePort {
    void saveCategory(Category category);
    Category getCategory(String name);
    List<Category> getAllCategories(Integer page, Integer size, boolean ascending);
}

