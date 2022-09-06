package com.bootcamp.literarias.repository;

import com.bootcamp.literarias.dto.ObraDto;
import com.bootcamp.literarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    List<Obra> findByAutor(String nombre);

    List<Obra> findByNombreContaining(String nombre);

    List<Obra> findByCantidadPaginasGreaterThan(Integer pages);

    List<Obra> findByAnioPublicacionLessThanEqual(Integer anio);

    List<Obra> findByAnioPublicacionGreaterThanEqual(Integer anio);

   List<Obra> findByEditorial(String editorial);
}
