package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.PromoPublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;

import java.util.List;

import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationCreateDTO;

public interface IPublicationRepository {
  List<Publication> getPublications();

  List<Publication> getListPublicationsById(Integer userId);

  Publication createPublication(PublicationCreateDTO publicationDTO);
  List<PromoPublicationDTO> getListPromoPublicationById(Integer userId);

}
