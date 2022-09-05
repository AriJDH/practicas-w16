package com.bootcamp.literarias.repository;

import com.bootcamp.literarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    Iterable<Obra> getNombreAutor(String nombre);

    Iterable<Obra> getNombreObra(String nombre);

    Iterable<Obra> getObrasCantidadByPaginas(Integer pages);

    Iterable<Obra> getObrasAntesByAnio(String fecha);

    Iterable<Obra> getObrasDespuesByAnio(String fecha);

    Iterable<Obra> getObrasEditorial(String editorial);
}
