package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.DiscountedProductSellerDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;

import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;

public interface IProductService {
  ProductDTO getProductById(Integer idProduct);

  ResponseApiDTO CreateProduct(RequestCreatePublicationDTO publicationDTO);
  DiscountedProductSellerDTO discountedProducts(Integer userId);
}