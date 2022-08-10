package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;

public interface IPublicationService {

    Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO);
}
