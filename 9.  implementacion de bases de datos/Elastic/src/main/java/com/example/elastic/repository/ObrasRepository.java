package com.example.elastic.repository;

import com.example.elastic.entity.ObrasLiterarias;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObrasRepository extends ElasticsearchRepository<ObrasLiterarias,String> {
    List<ObrasLiterarias> findObrasLiterariasByAutor(String autor);
    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    List<ObrasLiterarias> findByNombreObraLike(String title);

    @Override
    List<ObrasLiterarias> findAll();

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    List<ObrasLiterarias> findAllByCantidadDePaginasGreaterThan(Integer paginas);

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).

    List<ObrasLiterarias> findAllByAnioPublicacionBetween(Integer d,Integer a);

    List<ObrasLiterarias> findAllByAnioPublicacionGreaterThan(Integer d);

    List<ObrasLiterarias> findAllByAnioPublicacionLessThan(Integer d);
//Retornar las obras de una misma editorial.




}
