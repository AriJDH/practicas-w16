package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PublicationRepository implements IPublicationRepository {
  List<Publication> publications = new ArrayList<>();

  @PostConstruct
  private void loadData() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date1 = LocalDate.parse("09-08-2022", dtf);
    LocalDate date2 = LocalDate.parse("02-08-2022", dtf);
    LocalDate date3 = LocalDate.parse("18-04-2022", dtf);

    publications.add(new Publication(1, 104, date1, 100, 100, 150.0, false, 0.0));
    publications.add(new Publication(2, 104, date2, 200, 200, 350.0, false, 0.0));
    publications.add(new Publication(2, 104, date3, 300, 200, 350.0, false, 0.0));
  }

  @Override
  public List<Publication> getPublications() {
    return publications;
  }

  @Override
  public List<Publication> getListPublicationsById(Integer userId) {
    return publications.stream().filter(x -> x.getUserId().equals(userId)).collect(Collectors.toList());
  }

  @Override
  public Publication createPublication(Publication publication) {

    System.out.println(publication);

    Boolean successValidate = validateFields(publication);
    if (!successValidate) return null;

    if (publication.getHasPromo() == null) {
      publication.setHasPromo(false);
    }

    if (publication.getDiscount() == null) {
      publication.setDiscount(0.0);
    }

    publication.setPublicationId(publications.size() + 1);

    publications.add(publication);
    return publication;

  }

  private Boolean validateFields(Publication publication) {

    return publication.getUserId() != null &&
        publication.getDate() != null &&
        publication.getCategory() != null &&
        publication.getPrice() != null &&
        publication.getProductId() != null;
  }

}
