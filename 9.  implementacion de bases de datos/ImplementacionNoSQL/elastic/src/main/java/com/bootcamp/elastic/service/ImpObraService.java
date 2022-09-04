package com.bootcamp.elastic.service;

import java.util.List;

import com.bootcamp.elastic.entity.Obra;
import com.bootcamp.elastic.repository.ObraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ImpObraService
 */

@Service

public class ImpObraService implements IObraService {

   @Autowired
   ObraRepository obraRepository;

   @Override
   public List<Obra> createObras(List<Obra> listObra) {
      return (List<Obra>)obraRepository.saveAll(listObra);
   }

   @Override
   public Iterable<Obra> listObras() {
      return obraRepository.findAll();   
   }

   @Override
   public Iterable<Obra> findByNombreAutor(String nombre) {
      return obraRepository.findByNombreAutor(nombre);
   }

   @Override
   public Iterable<Obra> findByNombreObraLike(String nombre) {
      return obraRepository.findByNombreObraLike(nombre);   
   }

   @Override
   public Iterable<Obra> findByCantidadDePaginasGreaterThan(Integer pages) {
      return obraRepository.findByCantidadDePaginasGreaterThan(pages);   
   }

   @Override
   public Iterable<Obra> findByAnioPublicacionAfter(String fecha) {
      return obraRepository.findByAnioPublicacionAfter(fecha);   
   }

   @Override
   public Iterable<Obra> findByAnioPublicacionBefore(String fecha) {
      return obraRepository.findByAnioPublicacionBefore(fecha);   
   }




}
