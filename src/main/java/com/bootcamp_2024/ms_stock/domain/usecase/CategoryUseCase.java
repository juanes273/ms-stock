package com.bootcamp_2024.ms_stock.domain.usecase;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.bootcamp_2024.ms_stock.domain.api.CategoryServicePort;
import com.bootcamp_2024.ms_stock.domain.exception.CategoryDescriptionMissingException;
import com.bootcamp_2024.ms_stock.domain.exception.CategoryDescriptionTooLongException;
import com.bootcamp_2024.ms_stock.domain.exception.CategoryNameTooLongException;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import com.bootcamp_2024.ms_stock.domain.spi.CategoryPersistencePort;
import static com.bootcamp_2024.ms_stock.domain.utils.DomainVariables.MAX_DESCRIPTION_LENGTH;
import static com.bootcamp_2024.ms_stock.domain.utils.DomainVariables.MAX_NAME_LENGTH;

import java.util.List;
import java.util.Optional;



public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        validateCategory(category);
        categoryPersistencePort.saveCategory(category);
    }

    private void validateCategory(Category category) {
        // Validate name uniqueness
        Optional<CategoryEntity> existingCategory = categoryPersistencePort.findByName(category.getName());
        if (existingCategory.isPresent()) {
            throw new CategoryAlreadyExistsException(category.getName());
        }

        // Validate name length
        if (category.getName().length() > MAX_NAME_LENGTH) {
            throw new CategoryNameTooLongException(MAX_NAME_LENGTH);
        }

        // Validate description presence
        if (category.getDescription() == null || category.getDescription().isEmpty()) {
            throw new CategoryDescriptionMissingException();
        }

        // Validate description length
        if (category.getDescription().length() > MAX_DESCRIPTION_LENGTH) {
            throw new CategoryDescriptionTooLongException(MAX_DESCRIPTION_LENGTH);
        }
    }

    @Override
    public Category getCategory(String name) {
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public List<Category> getAllCategories(Integer page, Integer size, boolean ascending) {
        return categoryPersistencePort.getAllCategories(page, size, ascending);
    }

}
