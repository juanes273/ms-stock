package com.bootcamp_2024.ms_stock.aplicacion.service;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.infraestructura.persistencia.entity.CategoriaEntity;
import com.bootcamp_2024.ms_stock.infraestructura.persistencia.repository.CategoriaJpaRepository;
import com.bootcamp_2024.ms_stock.infraestructura.mapper.CategoriaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CategoriaServiceTest {

    @Mock
    private CategoriaJpaRepository categoriaJpaRepository;

    @Mock
    private CategoriaMapper categoriaMapper;

    @InjectMocks
    private CategoriaService categoriaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void crearCategoria_nombreDuplicado_lanzaExcepcion() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre("Existente");
        categoriaDTO.setDescripcion("Descripción válida");

        when(categoriaJpaRepository.existsByNombre("Existente")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> {
            categoriaService.crearCategoria(categoriaDTO);
        });
    }

    @Test
    public void crearCategoria_descripcionVacia_lanzaExcepcion() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre("NuevaCategoria");
        categoriaDTO.setDescripcion("");

        assertThrows(IllegalArgumentException.class, () -> {
            categoriaService.crearCategoria(categoriaDTO);
        });
    }

    @Test
    public void crearCategoria_nombreLargo_lanzaExcepcion() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre("EsteNombreTieneMasDeCincuentaCaracteresYDeberiaFallar");
        categoriaDTO.setDescripcion("Descripción válida");

        assertThrows(IllegalArgumentException.class, () -> {
            categoriaService.crearCategoria(categoriaDTO);
        });
    }

    @Test
    public void crearCategoria_descripcionLarga_lanzaExcepcion() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre("Nombre válido");
        categoriaDTO.setDescripcion("Esta descripción tiene más de noventa caracteres, lo que debería hacer que falle la creación. Esto es solo un texto para superar el límite.");

        assertThrows(IllegalArgumentException.class, () -> {
            categoriaService.crearCategoria(categoriaDTO);
        });
    }

    @Test
    public void crearCategoria_validaDatos_correctamenteGuardada() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre("CategoriaValida");
        categoriaDTO.setDescripcion("Descripción válida");

        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombre(categoriaDTO.getNombre());
        categoriaEntity.setDescripcion(categoriaDTO.getDescripcion());

        when(categoriaJpaRepository.existsByNombre(categoriaDTO.getNombre())).thenReturn(false);
        when(categoriaMapper.toEntity(categoriaDTO)).thenReturn(categoriaEntity);
        when(categoriaJpaRepository.save(categoriaEntity)).thenReturn(categoriaEntity);
        when(categoriaMapper.toDto(categoriaEntity)).thenReturn(categoriaDTO);

        CategoriaDTO result = categoriaService.crearCategoria(categoriaDTO);

        verify(categoriaJpaRepository).save(categoriaEntity);
        assertEquals(categoriaDTO, result);
    }
}
