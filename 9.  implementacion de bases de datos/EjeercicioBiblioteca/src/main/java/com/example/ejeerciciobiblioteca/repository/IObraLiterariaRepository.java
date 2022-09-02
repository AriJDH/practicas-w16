package com.example.ejeerciciobiblioteca.repository;

import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,String> {

    List<ObraLiteraria> findByAutorEqualsIgnoreCase(String autor);

    List<ObraLiteraria> findByNombreContainsIgnoreCase(String nombre);

    List<ObraLiteraria> findByCantDePaginasIsGreaterThan(Integer cantDePaginas);

    List<ObraLiteraria> findByAnioPrimeraPublicacionIsLessThan(Integer anio);

    List<ObraLiteraria> findByAnioPrimeraPublicacionIsGreaterThan(Integer anio);

    List<ObraLiteraria> findByEditorialEqualsIgnoreCase(String editorial);
}
