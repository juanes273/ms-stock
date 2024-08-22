package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.entrada.controller;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.aplicacion.mapper.CategoriaDtoMapper;
import com.bootcamp_2024.ms_stock.dominio.paginacion.Orden;
import com.bootcamp_2024.ms_stock.dominio.paginacion.Paginacion;
import com.bootcamp_2024.ms_stock.dominio.paginacion.PaginacionImpl;
import com.bootcamp_2024.ms_stock.aplicacion.service.CategoriaService;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private final CategoriaService categoriaService;
    private final CategoriaDtoMapper categoriaMapper;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaDtoMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping("/listar")
    public List<CategoriaDTO> listarCategorias(
            @RequestParam(value = "sort", defaultValue = "true") Boolean ascendente,
            @RequestParam(value = "page", defaultValue = "0") Integer pagina,
            @RequestParam(value = "size", defaultValue = "10") Integer tamanio) {

        Paginacion paginacion = new PaginacionImpl(pagina, tamanio, ascendente ? Orden.ASCENDENTE : Orden.DESCENDENTE);
        List<Categoria> categorias = categoriaService.listarCategorias(paginacion);
        return categorias.stream().map(categoriaMapper::toDto).toList();
    }

}
