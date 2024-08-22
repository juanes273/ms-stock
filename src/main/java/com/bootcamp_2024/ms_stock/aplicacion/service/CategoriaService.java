package com.bootcamp_2024.ms_stock.aplicacion.service;


import com.bootcamp_2024.ms_stock.aplicacion.excepciones.CategoriaAlreadyExistsException;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria crearCategoria(Categoria categoria) {
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new CategoriaAlreadyExistsException("El nombre de la categoría ya existe: " + categoria.getNombre());
        }
        return categoriaRepository.save(categoria);
    }
}