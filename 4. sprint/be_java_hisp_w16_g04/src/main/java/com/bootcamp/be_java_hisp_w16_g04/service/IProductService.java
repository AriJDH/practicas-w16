package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;

public interface IProductService {

    ProductDTO getProductById(Integer idProduct);
    String CreateProduct(RequestCreatePublicationDTO publicationDTO);
}