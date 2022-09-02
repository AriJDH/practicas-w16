package com.ndemaio.ejercicioproductoselasticsearch.repository;

import com.ndemaio.ejercicioproductoselasticsearch.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
}
