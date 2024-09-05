package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String name) {
        super("Category with the given name already exists.");
    }
}
