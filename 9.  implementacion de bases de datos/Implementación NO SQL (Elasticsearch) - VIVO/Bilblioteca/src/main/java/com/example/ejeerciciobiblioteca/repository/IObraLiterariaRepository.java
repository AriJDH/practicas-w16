package com.example.ejeerciciobiblioteca.repository;

import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,String> {
    //Retornar las obras de un autor dado por el usuario.
    List<ObraLiteraria> findObraLiterariaByAutor(String autor);
    //Retornar las obras de un autor dado por el usuario.
    List<ObraLiteraria> findObraLiterariaByNombreLike(String nombre);
    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    List<ObraLiteraria> findObraLiterariaByCantPaginasGreaterThan(Integer paginas);
    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    List<ObraLiteraria> findObraLiterariaByAnioPublicacionGreaterThan(Integer despues);
    List<ObraLiteraria> findObraLiterariaByAnioPublicacionLessThan(Integer antes);
    //Retornar las obras de una misma editorial.
    List<ObraLiteraria> findObraLiterariaByEditorialLike(String editorial);
}
