package com.example.obrasliterarias.service;


import com.example.obrasliterarias.dto.ObraConIdDto;
import com.example.obrasliterarias.dto.ObraDto;

import java.util.Date;
import java.util.List;

public interface IObraServicio {

    ObraConIdDto crearObra(ObraDto obraDto);

    List<ObraConIdDto> listarObras();

    ObraConIdDto modificarObra(ObraConIdDto obraDto);

    void eliminarObra(String id);

    List<ObraConIdDto> findByAutor(String autor);

    List<ObraConIdDto> findByNombreContaining(String nombre);

    List<ObraConIdDto> findByCantPaginasGreaterThan(Integer cant);

    List<ObraConIdDto> findByFechaPublicacionBefore(Date fecha);

    List<ObraConIdDto> findByFechaPublicacionAfter(Date fecha);

    List<ObraConIdDto> findByEditorial(String editorial);
}
