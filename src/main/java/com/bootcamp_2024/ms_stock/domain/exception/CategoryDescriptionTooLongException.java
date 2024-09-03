package com.bootcamp_2024.ms_stock.domain.exception;

public class CategoryDescriptionTooLongException extends RuntimeException {
    public CategoryDescriptionTooLongException(int maxLength) {
        super("Category description exceeds maximum length of " + maxLength + " characters.");
    }
}
