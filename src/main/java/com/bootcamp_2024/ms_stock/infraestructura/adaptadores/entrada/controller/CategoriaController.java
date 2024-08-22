package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.entrada.controller;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.aplicacion.service.CategoriaService;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.mapper.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @PostMapping("/crear")
    public CategoriaDTO crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toDomain(categoriaDTO);
        Categoria guardada = categoriaService.save(categoria);
        return categoriaMapper.toDto(guardada);
    }
}
