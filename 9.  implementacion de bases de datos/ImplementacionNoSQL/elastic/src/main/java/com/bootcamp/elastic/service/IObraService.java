package com.bootcamp.elastic.service;

import java.util.List;

import com.bootcamp.elastic.entity.Obra;

/**
 * IObraService
 */

public interface IObraService {

   List<Obra> createObras (List<Obra> listObra);

   Iterable<Obra> listObras ();   

   Iterable<Obra> findByNombreAutor (String nombre);   

   Iterable<Obra> findByNombreObraLike (String nombre);   

   Iterable<Obra> findByCantidadDePaginasGreaterThan(Integer pages);

   Iterable<Obra> findByAnioPublicacionAfter(String fecha);   

   Iterable<Obra> findByAnioPublicacionBefore(String fecha);   

}
