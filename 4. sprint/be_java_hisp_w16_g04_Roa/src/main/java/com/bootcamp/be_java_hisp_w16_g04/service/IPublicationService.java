package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;

import java.util.List;

public interface IPublicationService {

  ListProductByDateDTO getListProductByDate(Integer userId, String order);

  Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO);

  PromoPotsDTO getListPromoProduct(Integer userId);

  ListProductByHasPromo getListAllPromoProduct(Integer userId);

  // ---- Andres ---- //

  //List<ProductDTO> getListProductHasPromo(Integer userId);

}
