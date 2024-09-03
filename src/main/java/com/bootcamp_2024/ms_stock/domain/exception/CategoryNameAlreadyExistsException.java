package com.bootcamp_2024.ms_stock.domain.exception;

public class CategoryNameAlreadyExistsException extends RuntimeException {
    public CategoryNameAlreadyExistsException(String name) {
        super("Category name '" + name + "' already exists.");
    }
}
