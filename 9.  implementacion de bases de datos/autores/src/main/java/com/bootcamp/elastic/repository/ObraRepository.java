package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra,String> {
    List<Obra> findByAutor(String autor);
    List<Obra> findByNombreContaining(String nombre);
    List<Obra> findByCantPaginasGreaterThan(Integer cantidadPaginas);
    List<Obra> findByAnioPublicacionAfter (Integer fecha);
    List<Obra> findByAnioPublicacionBefore (Integer fecha);
    List<Obra> findByEditorial(String editorial);


}
