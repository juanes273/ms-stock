package com.bootcamp_2024.ms_stock.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;

}


