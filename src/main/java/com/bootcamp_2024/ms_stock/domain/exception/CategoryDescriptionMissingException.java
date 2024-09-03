package com.bootcamp_2024.ms_stock.domain.exception;

public class CategoryDescriptionMissingException extends RuntimeException {
    public CategoryDescriptionMissingException() {
        super("Category description is missing.");
    }
}
