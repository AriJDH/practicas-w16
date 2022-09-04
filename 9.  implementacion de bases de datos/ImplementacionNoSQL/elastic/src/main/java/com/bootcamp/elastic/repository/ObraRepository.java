package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Obra;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * ObraRepository
 */

@Repository

public interface ObraRepository extends ElasticsearchRepository<Obra,String> {

   Iterable<Obra> findByNombreAutor(String nombre);   

   Iterable<Obra> findByNombreObraLike(String nombre);   

   Iterable<Obra> findByCantidadDePaginasGreaterThan(Integer pages);

   Iterable<Obra> findByAnioPublicacionAfter(String fecha);   

   Iterable<Obra> findByAnioPublicacionBefore(String fecha);   
   
}
