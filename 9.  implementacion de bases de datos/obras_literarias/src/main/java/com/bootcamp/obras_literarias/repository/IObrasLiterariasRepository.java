package com.bootcamp.obras_literarias.repository;

import com.bootcamp.obras_literarias.model.ObrasLiterarias;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObrasLiterarias,String> {
    List<ObrasLiterarias> findByAutor(String autor);
    List<ObrasLiterarias> findByNombreContainsIgnoreCase(String nombre);
    List<ObrasLiterarias> findByPaginasGreaterThan(Integer paginas);
    List<ObrasLiterarias> findByAnioPublicacionGreaterThan(Integer anio);
    List<ObrasLiterarias> findByAnioPublicacionLessThan(Integer anio);
    List<ObrasLiterarias> findByEditorialIgnoreCase(String editorial);
}
