package com.bootcamp.literarias.service;

import com.bootcamp.literarias.dto.ObraDto;

import java.util.List;

public interface IObraService {

    ObraDto create(ObraDto productoDto);

    List<ObraDto> findByAutor(String nombre);

   List<ObraDto> findByObraContaining(String nombre);

    List<ObraDto> findByCantidadPaginasGreaterThan(Integer pages);

    List<ObraDto> findByAnioPublicacionLessThanEqual(Integer anio);

    List<ObraDto> findByAnioPublicacionGreaterThanEqual(Integer anio);

    List<ObraDto> findByEditorial(String editorial);
}
