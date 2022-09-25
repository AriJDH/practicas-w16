package com.bootcamp.elastic.service;

import com.bootcamp.elastic.DTO.ObraDTO;
import com.bootcamp.elastic.model.Obra;

import java.util.List;

public interface IObraService {
    String saveObra(ObraDTO obraDTO);
    List<ObraDTO> findByAutor(String autor);

    List<ObraDTO> findByTitulo(String titulo);
}
