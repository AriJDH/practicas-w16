package com.curso.servicioproductos.models.service;

import com.curso.servicioproductos.models.entity.Product;

import java.util.List;

public interface IProductService {
  List<Product> findAll();
  Product findById(Long id);
}
