package com.bootcamp_2024.ms_stock.infraestructura.persistencia.repository;

import com.bootcamp_2024.ms_stock.infraestructura.persistencia.entity.CategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    Page<CategoriaEntity> findAll(Pageable pageable);
}
