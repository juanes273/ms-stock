package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.adapter;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.mapper.CategoryEntityMapper;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.repository.CategoryRepository;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import com.bootcamp_2024.ms_stock.domain.spi.CategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
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

    @Override
    public Category getCategory(String name) {
        CategoryEntity categoryEntity = categoryRepository.findByNameContaining(name)
                .orElseThrow(ElementNotFoundException::new);
        return categoryEntityMapper.toModel(categoryEntity);
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer size, boolean ascending) {
        Pageable pagination = PageRequest.of(page, size);
        List<CategoryEntity> categories = ascending
                ? categoryRepository.findAllByOrderByNameAsc(pagination).getContent()
                : categoryRepository.findAllByOrderByNameDesc(pagination).getContent();
        if (categories.isEmpty()) {
            throw new ElementNotFoundException();
        }
        return categoryEntityMapper.toModelList(categories);
    }



}
