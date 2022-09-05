package com.example.elastic.service;

import com.example.elastic.dto.ListaObraDTO;
import com.example.elastic.dto.MensajeDTO;
import com.example.elastic.dto.ObraDTO;
import com.example.elastic.model.ObrasLiterarias;

import java.util.List;

public interface IObrasLiterariasService {

    ListaObraDTO findByAutor(String autor);
    ListaObraDTO findByNombreContainsIgnoreCase(String nombre);
    ListaObraDTO findByPaginasGreaterThan(Integer paginas);
    ListaObraDTO findByAnioPublicacionAfter(Integer anio);
    ListaObraDTO findByAnioPublicacionBefore(Integer anio);
    ListaObraDTO findByEditorial(String editorial);
    MensajeDTO save(List<ObraDTO> obras);
}
