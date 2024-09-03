package com.bootcamp_2024.ms_stock.adapters.driving.http.mapper;

import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    CategoryResponse toCategoryResponse(Category category);
}
