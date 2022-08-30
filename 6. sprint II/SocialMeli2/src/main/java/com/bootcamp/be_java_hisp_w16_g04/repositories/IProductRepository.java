package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Product;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;

public interface IProductRepository {
    Product getProductById(Integer idProduct);

    Product createProduct(ProductCreateDTO productDTO);

}
