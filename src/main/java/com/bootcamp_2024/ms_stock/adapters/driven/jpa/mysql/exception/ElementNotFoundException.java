package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.exception;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("The requested element was not found.");
    }
}
