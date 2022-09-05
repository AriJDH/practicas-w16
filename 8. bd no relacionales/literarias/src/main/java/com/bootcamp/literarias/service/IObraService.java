package com.bootcamp.literarias.service;

import com.bootcamp.literarias.dto.ObraDto;

import java.util.List;

public interface IObraService {

    ObraDto create(ObraDto productoDto);

    List<ObraDto> getNombreAutor(String nombre);

    List<ObraDto> getNombreObra(String nombre);

    List<ObraDto> getObrasCantidadByPaginas(Integer pages);

    List<ObraDto> getObrasAntesByAnio(String fecha);

    List<ObraDto> getObrasDespuesByAnio(String fecha);

    List<ObraDto> getObrasEditorial(String editorial);
}
