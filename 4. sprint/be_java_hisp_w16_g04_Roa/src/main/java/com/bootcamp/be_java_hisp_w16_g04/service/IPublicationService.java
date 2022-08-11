package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.PromoPotsDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;

import java.util.List;

public interface IPublicationService {

  ListProductByDateDTO getListProductByDate(Integer userId, String order);

  Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO);

  PromoPotsDTO getListPromoProduct(Integer userId);

  // ---- Andres ---- //

  //List<ProductDTO> getListProductHasPromo(Integer userId);

}
