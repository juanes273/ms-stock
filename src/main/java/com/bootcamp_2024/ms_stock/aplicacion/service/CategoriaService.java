package com.bootcamp_2024.ms_stock.aplicacion.service;


import com.bootcamp_2024.ms_stock.aplicacion.excepciones.CategoriaAlreadyExistsException;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.repository.CategoriaRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepositoryAdapter categoriaRepositoryAdapter;

    @Autowired
    public CategoriaService(CategoriaRepositoryAdapter categoriaRepositoryAdapter) {
        this.categoriaRepositoryAdapter = categoriaRepositoryAdapter;
    }

    public Categoria crearCategoria(Categoria categoria) {
        if (categoriaRepositoryAdapter.existsByNombre(categoria.getNombre())) {
            throw new CategoriaAlreadyExistsException("El nombre de la categoría ya existe: " + categoria.getNombre());
        }
        return categoriaRepositoryAdapter.save(categoria);
    }
}