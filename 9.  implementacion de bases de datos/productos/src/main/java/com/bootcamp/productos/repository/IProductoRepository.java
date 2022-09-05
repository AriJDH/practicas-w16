package com.bootcamp.productos.repository;

import com.bootcamp.productos.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
}
