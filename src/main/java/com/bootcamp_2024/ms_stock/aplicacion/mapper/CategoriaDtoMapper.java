package com.bootcamp_2024.ms_stock.aplicacion.mapper;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoriaDTO toDto(Categoria categoria);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Categoria toDomain(CategoriaDTO categoriaDTO);
}
