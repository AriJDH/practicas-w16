package com.bootcamp.elsproductos.repository;

import com.bootcamp.elsproductos.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
}