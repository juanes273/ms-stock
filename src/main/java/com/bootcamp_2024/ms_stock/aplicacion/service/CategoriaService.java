package com.bootcamp_2024.ms_stock.aplicacion.service;


import com.bootcamp_2024.ms_stock.aplicacion.excepciones.CategoriaNotFoundException;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository.CategoriaRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepositoryAdapter categoriaRepositoryAdapter;

    @Autowired
    public CategoriaService(CategoriaRepositoryAdapter categoriaRepositoryAdapter) {
        this.categoriaRepositoryAdapter = categoriaRepositoryAdapter;
    }

    public List<Categoria> listarCategorias(boolean ascendente, int pagina, int tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio, ascendente ? Sort.by("nombre").ascending() : Sort.by("nombre").descending());
        List<Categoria> categorias = categoriaRepositoryAdapter.findAll(pageRequest.getSort(), pageRequest);

        if (categorias.isEmpty()) {
            throw new CategoriaNotFoundException("No se encontraron categorías");
        }

        return categorias;
    }
}