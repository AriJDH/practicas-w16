package com.bootcamp.be_java_hisp_w16_g04.Repository;

import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.PublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class PublicationRepositoryTest {

  @Autowired
  PublicationRepository publicationRepository;

  @Autowired
  IPublicationRepository iPublicationRepository;

  @Test
  void getPublicationsTest() {
    List<Publication> publicationList = TestUtilsGenerator.getListPublications();

    publicationRepository.setPublications(publicationList);

    List<Publication> listResult = publicationRepository.getPublications();
    Assertions.assertEquals(listResult, listResult);

  }

}
