package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.entity.Product;

import java.util.List;

public interface IProductRepository {

    Product getProductById(Integer productId);

    void save(List<Product> product);
}
