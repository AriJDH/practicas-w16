package com.example.ejeerciciobiblioteca.service;

import com.example.ejeerciciobiblioteca.dto.ObraLiterariaDto;
import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {

    void createObraLiteraria(ObraLiterariaDto obra);

    List<ObraLiterariaDto> getAllObraLiterarias();

    List<ObraLiterariaDto> buscarPorAutor(String nombre);

    List<ObraLiterariaDto> buscarPorNombre(String nombre);

    List<ObraLiterariaDto> buscarConCantPaginasMasQue(Integer cantPaginas);

    List<ObraLiterariaDto> buscarConAnioMenorA(Integer anio);

    List<ObraLiterariaDto> buscarConAnioMayorA(Integer anio);

    List<ObraLiterariaDto> buscarPorEditorial(String editorial);

}
