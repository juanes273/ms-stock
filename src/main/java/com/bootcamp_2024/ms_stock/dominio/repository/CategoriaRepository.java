package com.bootcamp_2024.ms_stock.dominio.repository;

import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import java.util.Optional;

public interface CategoriaRepository {
    Optional<Categoria> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    Categoria save(Categoria categoria);}

