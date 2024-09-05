package com.bootcamp_2024.ms_stock.domain.spi;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistencePort {
    Optional<CategoryEntity> findByName(String name);
    Category getCategory(String name);
    List<Category> getAllCategories(Integer page, Integer size, boolean ascending);
}