package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository;

import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.paginacion.Orden;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import com.bootcamp_2024.ms_stock.dominio.paginacion.Paginacion;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.mapper.CategoriaEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositoryAdapter implements CategoriaRepository {

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepository;

    @Autowired
    private CategoriaEntityMapper categoriaMapper;

    @Override
    public Optional<Categoria> findByNombre(String nombre) {
        return categoriaJpaRepository.findByNombre(nombre)
                .map(categoriaMapper::toDomain);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return categoriaJpaRepository.existsByNombre(nombre);
    }


    @Override
    public List<Categoria> findAll(Paginacion paginacion) {
        PageRequest pageRequest = PageRequest.of(paginacion.getPagina(), paginacion.getTamanio(),
                paginacion.getOrden() == Orden.ASCENDENTE ? Sort.by("nombre").ascending() : Sort.by("nombre").descending());
        return categoriaJpaRepository.findAll(pageRequest)
                .stream()
                .map(categoriaMapper::toDomain)
                .toList();
    }
}
