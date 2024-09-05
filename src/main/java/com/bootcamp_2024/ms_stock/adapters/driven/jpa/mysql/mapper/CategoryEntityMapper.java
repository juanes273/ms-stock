package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.mapper;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    Category toModel(CategoryEntity categoryEntity);
    CategoryEntity toEntity(Category category);
    List<Category> toModelList(List<CategoryEntity> categoryEntities);
}
