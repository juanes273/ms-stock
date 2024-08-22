package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository;

import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

}
