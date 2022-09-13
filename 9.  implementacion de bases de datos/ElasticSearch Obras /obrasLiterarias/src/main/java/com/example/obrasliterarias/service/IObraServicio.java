package com.example.obrasliterarias.service;


import com.example.obrasliterarias.dto.ObraConIdDto;
import com.example.obrasliterarias.dto.ObraDto;
import com.example.obrasliterarias.model.ObraLiteraria;

import java.util.List;

public interface IObraServicio {

    ObraConIdDto crearObras(ObraDto obraDto);

    List<ObraConIdDto> listarPorNombre(String nombre);

    List<ObraConIdDto> listarPorPalabra(String nombre);

    Iterable<ObraConIdDto> listarTodas();

    List<ObraConIdDto> listarPorPaginas(Integer cantidad);

    List<ObraConIdDto>listarPorEditorial(String editorial);
}
