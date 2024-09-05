package com.bootcamp_2024.ms_stock.adapters.driving.http.controller;

import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.request.AddCategoryRequest;
import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.request.UpdateCategoryRequest;
import com.bootcamp_2024.ms_stock.adapters.driving.http.dto.response.CategoryResponse;
import com.bootcamp_2024.ms_stock.adapters.driving.http.mapper.CategoryRequestMapper;
import com.bootcamp_2024.ms_stock.adapters.driving.http.mapper.CategoryResponseMapper;
import com.bootcamp_2024.ms_stock.domain.api.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<Void> addCategory(@RequestBody AddCategoryRequest request) {
        categoryServicePort.saveCategory(categoryRequestMapper.addRequestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable String name) {
        return ResponseEntity.ok(categoryResponseMapper.toCategoryResponse(categoryServicePort.getCategory(name)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@RequestParam Integer page, @RequestParam Integer size, @RequestParam Boolean asc) {
        return ResponseEntity.ok(categoryResponseMapper.toCategoryResponseList(categoryServicePort.getAllCategories(page, size, asc)));
    }
}
