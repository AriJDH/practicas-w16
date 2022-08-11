package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;

public interface IProductService {
  ProductDTO getProductById(Integer idProduct);

  ResponseApiDTO createProduct(RequestCreatePublicationDTO publicationDTO);

  ResponseApiDTO createProduct(RequestCreatePublicationDiscountDTO publicationDiscountDTO);

  ResponseCountDiscountDTO countProductsDiscountByUserId(Integer userId);

  ResponseListDiscountDTO listProductsDiscountByUserId(Integer userId);
}