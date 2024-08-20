package com.bootcamp_2024.ms_stock.dominio.repository;

import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {

    Optional<Categoria> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    Categoria save(Categoria categoria);

    List<Categoria> findAll(Sort sort, Pageable pageable);
}
