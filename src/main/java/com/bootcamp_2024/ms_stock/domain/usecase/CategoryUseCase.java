package com.bootcamp_2024.ms_stock.domain.usecase;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.exception.CategoryAlreadyExistsException;
import com.bootcamp_2024.ms_stock.domain.api.CategoryServicePort;
import com.bootcamp_2024.ms_stock.domain.exception.CategoryDescriptionMissingException;
import com.bootcamp_2024.ms_stock.domain.exception.CategoryDescriptionTooLongException;
import com.bootcamp_2024.ms_stock.domain.exception.CategoryNameTooLongException;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import com.bootcamp_2024.ms_stock.domain.pagination.Pagination;
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
    public Category getCategory(String name) {
        return categoryPersistencePort.getCategory(name);
    }

    @Override
    public List<Category> getAllCategories(Pagination pagination) {
        return categoryPersistencePort.getAllCategories(pagination);
    }

}
