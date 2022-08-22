package com.bootcamp.be_java_hisp_w16_g04.Repository;

import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.PublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
    public void getPublicationsTest() {
        List<Publication> listPublication = TestUtilsGenerator.getListPublications();
        publicationRepository.setPublications(listPublication);

        List<Publication> listResult = publicationRepository.getPublications();

        Assertions.assertEquals(listPublication, listResult);
    }

    @Test
    public void getListPublicationsById() {
        List<Publication> listPublication = TestUtilsGenerator.getListPublications();
        publicationRepository.setPublications(listPublication);

        List<Publication> publications = publicationRepository.getListPublicationsById(1);

        Assertions.assertEquals(1, publications.size());
    }
}
