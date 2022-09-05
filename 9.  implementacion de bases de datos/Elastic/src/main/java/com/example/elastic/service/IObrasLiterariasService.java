package com.example.elastic.service;

import com.example.elastic.model.ObrasLiterarias;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IObrasLiterariasService {

    List<ObrasLiterarias> findByAutor(String autor);
    List<ObrasLiterarias> findByNombreContainsIgnoreCase(String nombre);
    List<ObrasLiterarias> findByPaginasGreaterThan(Integer paginas);
    List<ObrasLiterarias> findByAnoPublicacionAfter(Integer anio);
    List<ObrasLiterarias> findByAnoPublicacionBefore(Integer anio);
    List<ObrasLiterarias> findByEditorial(String editorial);
    List<ObrasLiterarias> save(List<ObrasLiterarias> obras);
}
