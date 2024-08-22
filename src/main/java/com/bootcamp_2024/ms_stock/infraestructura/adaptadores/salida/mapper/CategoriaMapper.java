package com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.mapper;

import com.bootcamp_2024.ms_stock.aplicacion.dto.CategoriaDTO;
import com.bootcamp_2024.ms_stock.dominio.modelo.Categoria;
import com.bootcamp_2024.ms_stock.infraestructura.adaptadores.salida.persistencia.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoriaDTO toDto(CategoriaEntity categoriaEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoriaEntity toEntity(CategoriaDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    CategoriaEntity toEntity(Categoria categoria);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    Categoria toDomain(CategoriaEntity categoriaEntity);
}
