package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.entrada.controller;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.aplicacion.mapper.CategoriaDtoMapper;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.mapper.CategoriaEntityMapper;
import com.bootcamp_2024.ms_stock.aplicacion.service.CategoriaService;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepository;
    private final CategoriaService categoriaService;
    private final CategoriaDtoMapper categoriaMapper;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaDtoMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping("/listar")
    public List<CategoriaDTO> listarCategorias(
            @RequestParam(value = "ascendente", defaultValue = "true") Boolean ascendente,
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanio", defaultValue = "10") Integer tamanio) {

        List<Categoria> categorias = categoriaService.listarCategorias(ascendente, pagina, tamanio);

        return categorias.stream()
                .map(categoriaMapper::toDto)
                .toList();
    }

}
