package com.bootcamp_2024.ms_stock.aplicacion.service;

import com.bootcamp_2024.ms_stock.aplicacion.excepciones.CategoriaNotFoundException;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.paginacion.Paginacion;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(Paginacion paginacion) {
        List<Categoria> categorias = categoriaRepository.findAll(paginacion);
        if (categorias.isEmpty()) {
            throw new CategoriaNotFoundException("No se encontraron categorías");
        }
        return categorias;
    }
}
