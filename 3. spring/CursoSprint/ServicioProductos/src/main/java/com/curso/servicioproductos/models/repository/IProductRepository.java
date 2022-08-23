package com.curso.servicioproductos.models.repository;

import com.curso.servicioproductos.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {


}
