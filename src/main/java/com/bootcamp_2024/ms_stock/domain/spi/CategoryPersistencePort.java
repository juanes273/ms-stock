package com.bootcamp_2024.ms_stock.domain.spi;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.domain.model.Category;

import java.util.Optional;

public interface CategoryPersistencePort {
    void saveCategory(Category category);
    Optional<CategoryEntity> findByName(String name);
}