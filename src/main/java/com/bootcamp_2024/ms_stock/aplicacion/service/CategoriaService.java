package com.bootcamp_2024.ms_stock.aplicacion.service;


import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.dominio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new IllegalArgumentException("El nombre de la categoría ya existe");
        }
        return categoriaRepository.save(categoria);
    }
}