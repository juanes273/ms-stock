package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super("No data was found matching the criteria.");
    }
}
