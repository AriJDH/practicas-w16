package com.example.spring.elasticsearch.repository;

import com.example.spring.elasticsearch.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo,String> {
}
