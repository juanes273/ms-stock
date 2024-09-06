package com.bootcamp_2024.ms_stock.adapters.driving.http.controller;

import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.bootcamp_2024.ms_stock.adapters.driving.http.mapper.CategoryRequestMapper;
import com.bootcamp_2024.ms_stock.adapters.driving.http.mapper.CategoryResponseMapper;
import com.bootcamp_2024.ms_stock.domain.api.CategoryServicePort;
import com.bootcamp_2024.ms_stock.domain.model.Category;
import com.bootcamp_2024.ms_stock.domain.pagination.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryRestControllerAdapter {

    private final CategoryServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;


    @GetMapping("/{name}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable String name) {
        return ResponseEntity.ok(categoryResponseMapper.toCategoryResponse(categoryServicePort.getCategory(name)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize,
            @RequestParam Boolean ascending) {

        Pagination pagination = new Pagination(pageNumber, pageSize, ascending);
        List<Category> categories = categoryServicePort.getAllCategories(pagination);
        List<CategoryResponse> categoryResponses = categoryResponseMapper.toCategoryResponseList(categories);

        return ResponseEntity.ok(categoryResponses);
    }
}
