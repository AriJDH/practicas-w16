package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;

public interface IProductRepository {

    Product createProduct(ProductCreateDTO productDTO);

}
