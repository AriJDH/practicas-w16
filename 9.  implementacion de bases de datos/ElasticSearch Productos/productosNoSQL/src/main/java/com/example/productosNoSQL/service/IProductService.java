package com.example.productosNoSQL.service;

import com.example.productosNoSQL.dto.ProductDto;
import com.example.productosNoSQL.dto.StatusDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAllProduct();

    StatusDto createProduct(List<ProductDto> productDtoList);

    ProductDto updatedProduct(ProductDto productDto);
}
