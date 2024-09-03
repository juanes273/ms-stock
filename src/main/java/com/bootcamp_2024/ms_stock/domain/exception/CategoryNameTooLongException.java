package com.bootcamp_2024.ms_stock.domain.exception;

public class CategoryNameTooLongException extends RuntimeException {
    public CategoryNameTooLongException(int maxLength) {
        super("Category name exceeds maximum length of " + maxLength + " characters.");
    }
}
