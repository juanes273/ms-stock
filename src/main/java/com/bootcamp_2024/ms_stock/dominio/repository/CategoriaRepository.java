package com.bootcamp_2024.ms_stock.dominio.repository;

import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.paginacion.Paginacion;

import java.util.Optional;
import java.util.List;

public interface CategoriaRepository {
    Optional<Categoria> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    List<Categoria> findAll(Paginacion paginacion);
}

