package com.bootcamp.obras_literarias_elasticsearch.service;

import com.bootcamp.obras_literarias_elasticsearch.dto.ObraDto;
import com.bootcamp.obras_literarias_elasticsearch.model.Obra;

import java.util.List;

public interface IObraService {

     ObraDto createObra(ObraDto obraDto);

     List<ObraDto> getObrasByAuthor(String autor);

     List<ObraDto> findByNombreObra(String nombreObra);

     List<ObraDto> getByCantidadPaginas(Integer cantidadPaginas);

     List<ObraDto> getByAnioPublicacionGreaterThan(Integer anioPrimeraPublicacion);

     List<ObraDto> getByAnioPublicacionLessThan(Integer anioPrimeraPublicacion);
}
