package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseListPromoPublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseNumberPromoProductsDTO;

public interface IPublicationService {

  ListProductByDateDTO getListProductByDate(Integer userId, String order);
  ResponseListPromoPublicationDTO getListPromoPublication(Integer userId);
  ResponseNumberPromoProductsDTO getNumberPromoPublicationById(Integer userId);

}
