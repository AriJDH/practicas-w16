package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ApiPublicationsDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ProductsUserPromotionsDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;

public interface IPublicationService {

  ListProductByDateDTO getListProductByDate(Integer userId, String order);

  Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO);
  ProductsUserPromotionsDTO promoProductsByUserId(Integer userId);
  ApiPublicationsDTO allPromoPublications(String order);
  ApiPublicationsDTO getPublicationsByCategory(Integer category);
}
