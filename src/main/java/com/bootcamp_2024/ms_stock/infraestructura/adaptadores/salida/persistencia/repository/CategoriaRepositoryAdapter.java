package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository;

import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.mapper.CategoriaEntityMapper;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.entity.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Categoria save(Categoria categoria) {
        CategoriaEntity entity = categoriaMapper.toEntity(categoria);
        return categoriaMapper.toDomain(categoriaJpaRepository.save(entity));
    }

    @Override
    public List<Categoria> findAll(Sort sort, Pageable pageable) {
        return categoriaJpaRepository.findAll(pageable)
                .stream()
                .map(categoriaMapper::toDomain)
                .toList();
    }
}
