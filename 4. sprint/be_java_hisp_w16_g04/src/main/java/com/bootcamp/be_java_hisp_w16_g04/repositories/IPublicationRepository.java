package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Publication;

import java.util.List;

public interface IPublicationRepository {
    List<Publication> getPublications();
    List<Publication> getListPublicationsById(Integer userId);
}
