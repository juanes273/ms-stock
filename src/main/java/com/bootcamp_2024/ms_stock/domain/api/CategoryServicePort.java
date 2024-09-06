package com.bootcamp_2024.ms_stock.domain.api;

import com.bootcamp_2024.ms_stock.domain.model.Category;
import com.bootcamp_2024.ms_stock.domain.pagination.Pagination;

import java.util.List;

public interface CategoryServicePort {
    Category getCategory(String name);
    List<Category> getAllCategories(Pagination pagination);
}

