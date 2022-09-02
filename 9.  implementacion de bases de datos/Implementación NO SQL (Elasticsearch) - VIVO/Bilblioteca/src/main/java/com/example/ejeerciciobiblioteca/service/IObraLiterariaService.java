package com.example.ejeerciciobiblioteca.service;

import com.example.ejeerciciobiblioteca.dto.ObraLiterariaDto;
import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {

    void createObraLiteraria(ObraLiterariaDto obra);

    List<ObraLiterariaDto> getAllObraLiterarias();
    List<ObraLiterariaDto> getAllObraLiterariasPorAutor(String autor);

    List<ObraLiterariaDto> getAllObraLiterariaByNombreLike(String nombre);

    List<ObraLiterariaDto> getAllObraLiterariaByCantPaginasGreaterThan(Integer paginas);

    List<ObraLiterariaDto> getAllObraLiterariaByAnioPublicacionGreaterThan(Integer despues);
    List<ObraLiterariaDto> getAllObraLiterariaByAnioPublicacionLessThan(Integer antes);
    List<ObraLiterariaDto> getAllObraLiterariaByEditorialLike(String editorial);

}
