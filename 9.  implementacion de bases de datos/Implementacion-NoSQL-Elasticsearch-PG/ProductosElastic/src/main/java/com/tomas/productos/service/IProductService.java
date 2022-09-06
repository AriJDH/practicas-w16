package com.tomas.productos.service;

import com.tomas.productos.dto.CreateProductDTO;
import com.tomas.productos.dto.MessageDTO;
import com.tomas.productos.dto.ProductDTO;
import com.tomas.productos.dto.UpdateProductDto;

public interface IProductService {

    CreateProductDTO saveProduct(ProductDTO productDto);
    MessageDTO updateProduct(UpdateProductDto updateProductDto);

}
