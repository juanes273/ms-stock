package com.bootcamp_2024.ms_stock.aplicacion.service;


import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import com.bootcamp_2024.ms_stock.infraestructura.mapper.CategoriaMapper;
import com.bootcamp_2024.ms_stock.infraestructura.persistencia.entity.CategoriaEntity;
import com.bootcamp_2024.ms_stock.infraestructura.persistencia.repository.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        if (categoriaJpaRepository.existsByNombre(categoriaDTO.getNombre())) {
            throw new IllegalArgumentException("El nombre de la categoría ya existe");
        }

        CategoriaEntity categoriaEntity = categoriaMapper.toEntity(categoriaDTO);
        CategoriaEntity guardada = categoriaJpaRepository.save(categoriaEntity);
        return categoriaMapper.toDto(guardada);
    }
}