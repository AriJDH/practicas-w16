package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Integer idProduct);
}
