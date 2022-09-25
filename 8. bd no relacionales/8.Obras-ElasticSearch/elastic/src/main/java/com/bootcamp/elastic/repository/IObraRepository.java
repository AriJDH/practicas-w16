package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.model.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    List<Obra> findByAutor(String autor);

    List<Obra> findByTitulo(String nombre);
}
