package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.entity.Product;

public interface IProductRepository {

    Product getProductById(int productId);
}
