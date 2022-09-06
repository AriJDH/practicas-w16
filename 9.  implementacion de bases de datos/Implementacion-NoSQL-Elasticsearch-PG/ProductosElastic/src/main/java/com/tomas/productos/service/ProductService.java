package com.tomas.productos.service;

import com.tomas.productos.dto.CreateProductDTO;
import com.tomas.productos.dto.MessageDTO;
import com.tomas.productos.dto.ProductDTO;
import com.tomas.productos.dto.UpdateProductDto;
import com.tomas.productos.mapper.Mapper;
import com.tomas.productos.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Autowired
    Mapper mapper;


    @Override
    public CreateProductDTO saveProduct(ProductDTO productDto) {

        String id;
        id = productRepository.save(mapper.productDtoToProductEntity(productDto)).getId();

        CreateProductDTO create = new CreateProductDTO();

        if(id != null) {

            create.setIdProduct(id);
            create.setStatusCode(201);
            create.setMessage("Product created successful");

        } else {

            create.setStatusCode(500);
            create.setMessage("Error, Product not created");

        }

        return create;
    }

    @Override
    public MessageDTO updateProduct(UpdateProductDto updateProductDto) {

        String id;
        id = productRepository.save(mapper.updateProductDtoToProductEntity(updateProductDto)).getId();

        MessageDTO update = new MessageDTO();

        if(id != null) {

            update.setStatusCode(200);
            update.setMessage("Product updated successful");

        } else {

            update.setStatusCode(500);
            update.setMessage("Error, Product not updated");

        }

        return update;
    }

}
