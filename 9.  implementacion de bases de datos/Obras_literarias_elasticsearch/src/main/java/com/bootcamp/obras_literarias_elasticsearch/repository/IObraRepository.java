package com.bootcamp.obras_literarias_elasticsearch.repository;

import com.bootcamp.obras_literarias_elasticsearch.model.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    List<Obra> findByAutor(String autor);

    List<Obra> findByNombreObra(String nombreObra);

    List<Obra> findByCantidadPaginasGreaterThan(Integer cantidadPaginas);

    List<Obra> findByAnioPrimeraPublicacionGreaterThan(Integer anioPrimeraPublicacion);

    List<Obra> findByAnioPrimeraPublicacionLessThan(Integer anioPrimeraPublicacion);
}
