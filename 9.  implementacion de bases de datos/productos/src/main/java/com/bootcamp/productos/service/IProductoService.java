package com.bootcamp.productos.service;

import com.bootcamp.productos.dto.ProductoDto;

import java.util.List;

public interface IProductoService {

    ProductoDto create(ProductoDto productoDto);

    List<ProductoDto> getProducts();

    String delete(String id);
}
