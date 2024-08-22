package com.bootcamp_2024.ms_stock.aplicacion.excepciones;

public class CategoriaNotFoundException extends RuntimeException {

    public CategoriaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
