package com.bootcamp_2024.ms_stock.aplicacion.service;


import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(boolean ascendente, int pagina, int tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio, ascendente ? Sort.by("nombre").ascending() : Sort.by("nombre").descending());
        return categoriaRepository.findAll(pageRequest.getSort(), pageRequest);
    }
}