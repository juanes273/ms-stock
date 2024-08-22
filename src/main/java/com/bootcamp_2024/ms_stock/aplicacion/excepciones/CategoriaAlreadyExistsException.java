package com.bootcamp_2024.ms_stock.aplicacion.excepciones;

public class CategoriaAlreadyExistsException extends RuntimeException {
    public CategoriaAlreadyExistsException(String mensaje) {
        super(mensaje);
    }
}
