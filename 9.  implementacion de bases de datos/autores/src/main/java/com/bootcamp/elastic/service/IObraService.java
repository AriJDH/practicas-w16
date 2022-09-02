package com.bootcamp.elastic.service;

import com.bootcamp.elastic.entity.Obra;

import java.util.List;

public interface IObraService {
    Obra updateEmployee(Obra obra);
    List<Obra> createObras(List<Obra> obras);
    List<Obra> findByAutor(String autor);
    List<Obra> findByNombreContaining(String nombre);
    List<Obra> findByCantPaginasGreaterThan(Integer cantidadPaginas);
    List<Obra> findByAnioPublicacionAfter (Integer fecha);
    List<Obra> findByAnioPublicacionBefore (Integer fecha);
    List<Obra> findByEditorial(String editorial);

}
