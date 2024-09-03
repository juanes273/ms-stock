package com.bootcamp_2024.ms_stock.adapters.driving.http.mapper;

import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.request.UpdateCategoryRequest;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryRequestMapper {

    Category addRequestToCategory(AddCategoryRequest addCategoryRequest);
}
