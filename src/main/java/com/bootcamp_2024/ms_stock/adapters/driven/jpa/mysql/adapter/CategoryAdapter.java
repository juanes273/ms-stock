package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.adapter;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.mapper.CategoryEntityMapper;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.repository.CategoryRepository;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import com.bootcamp_2024.ms_stock.domain.spi.CategoryPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CategoryAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public Optional<CategoryEntity> findByName(String name) {
        return categoryRepository.findByName(name);
    }



}
