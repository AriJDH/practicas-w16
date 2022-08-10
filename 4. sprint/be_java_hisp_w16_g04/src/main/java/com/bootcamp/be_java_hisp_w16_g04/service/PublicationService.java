package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService implements IPublicationService{

    @Autowired
    IPublicationRepository iPublicationRepository;

    @Override
    public Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO) {

        PublicationDTO publicationDTO = new PublicationDTO(requestCreatePublicationDTO.getUserId(),
                requestCreatePublicationDTO.getDate(),
                requestCreatePublicationDTO.getCategory(),
                requestCreatePublicationDTO.getPrice(),
                requestCreatePublicationDTO.getProduct().getProductId() );

        Publication publication = iPublicationRepository.createPublication(publicationDTO);

        return publication != null;
    }
}
