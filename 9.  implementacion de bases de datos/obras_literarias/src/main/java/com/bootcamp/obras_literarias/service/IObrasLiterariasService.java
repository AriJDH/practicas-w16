package com.bootcamp.obras_literarias.service;

import com.bootcamp.obras_literarias.model.ObrasLiterarias;

import java.util.List;

public interface IObrasLiterariasService {

    List<ObrasLiterarias> findByAutor(String autor);

    List<ObrasLiterarias> findByTitulo(String nombre);

    List<ObrasLiterarias> findByCantidadPaginas(Integer paginas);

    List<ObrasLiterarias> findByAnioPublicacionGreaterThan(Integer anio);

    List<ObrasLiterarias> findByAnioPublicacionLessThan(Integer anio);

    List<ObrasLiterarias> findByEditorial(String editorial);

    List<ObrasLiterarias> save(List<ObrasLiterarias> obras);

    List<ObrasLiterarias> findAll();
}
