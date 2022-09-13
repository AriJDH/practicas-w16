package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasRepository extends ElasticsearchRepository<ObraLiteraria,String> {

    //Retornar las obras de un autor dado por el usuario
    @Query("{\"match\":{\"autor\":\"?0\"}}")
    List<ObraLiteraria> findObrasByAutor(String autor);

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @Query("{\"match\":{\"nombre\":\"?0\"}}")
    List<ObraLiteraria> findObrasByWord(String nombre);

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @Query("{\"bool\":{\"filter\":{\"range\":{\"cantPaginas\":{\"gte\":?0}}}}}")
    List<ObraLiteraria>findPages(Integer cantPaginas);

    //Retornar las obras de una misma editorial
    @Query("{\"match\":{\"editorial\":\"?0\"}}")
    List<ObraLiteraria> findByEditorial(String Editorial);

}
