package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDiscountDTO;

public interface IPublicationService {

  ListProductByDateDTO getListProductByDate(Integer userId, String order);

  Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO);

  Boolean createPublication(RequestCreatePublicationDiscountDTO requestCreatePublicationDiscountDTO);
}
