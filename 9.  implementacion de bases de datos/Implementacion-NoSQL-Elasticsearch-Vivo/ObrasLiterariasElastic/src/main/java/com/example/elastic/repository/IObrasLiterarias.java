package com.example.elastic.repository;

import com.example.elastic.model.ObrasLiterarias;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasLiterarias extends ElasticsearchRepository<ObrasLiterarias,String> {

    List<ObrasLiterarias> findByAutor(String autor);
    List<ObrasLiterarias> findByNombreContainsIgnoreCase(String nombre);
    List<ObrasLiterarias> findByPaginasGreaterThan(Integer paginas);
    List<ObrasLiterarias> findByAnioPublicacionAfter(Integer anio);
    List<ObrasLiterarias> findByAnioPublicacionBefore(Integer anio);
    List<ObrasLiterarias> findByEditorial(String editorial);

}
