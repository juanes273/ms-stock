package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.entrada.controller;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.mapper.CategoriaMapper;
import com.bootcamp_2024.ms_stock.aplicacion.service.CategoriaService;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository.CategoriaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaJpaRepository categoriaJpaRepository;
    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping("/listar")
    public List<CategoriaDTO> listarCategorias(
            @RequestParam(value = "ascendente", defaultValue = "true") Boolean ascendente,
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanio", defaultValue = "10") Integer tamanio) {

        // Configura PageRequest con los valores proporcionados o los valores predeterminados
        PageRequest pageRequest = PageRequest.of(pagina, tamanio,
                ascendente ? Sort.by("nombre").ascending() : Sort.by("nombre").descending());

        // Obtén el contenido de la página
        return categoriaJpaRepository.findAll(pageRequest)
                .getContent() // Aquí obtienes la lista de CategoriaEntity
                .stream()
                .map(categoriaMapper::toDto) // Aquí el mapeo debería funcionar correctamente
                .collect(Collectors.toList());
    }

}
