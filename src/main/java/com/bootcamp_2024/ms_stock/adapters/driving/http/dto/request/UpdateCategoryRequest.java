package com.bootcamp_2024.ms_stock.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateCategoryRequest {
    private final Long id;
    private final String name;
    private final String description;
}
