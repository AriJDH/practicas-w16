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
  List<Publication> publications = new ArrayList<Publication>();

  @PostConstruct
  private void loadData() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date1 = LocalDate.parse("09-08-2022", dtf);
    LocalDate date2 = LocalDate.parse("02-08-2022", dtf);
    LocalDate date3 = LocalDate.parse("18-04-2022", dtf);

    publications.add(new Publication(1, 104, date1, 100, 100, 150.0,false,0.0));
    publications.add(new Publication(2, 104, date2, 200, 200, 350.0, true,0.25));
    publications.add(new Publication(2, 104, date3, 300, 200, 350.0, false,0.0));
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
  public List<Publication> getListPublicationsPromoById(Integer userId) {
    return publications.stream().filter(x -> x.getUserId()
            .equals(userId) && x.getHasPromo().equals(true)).collect(Collectors.toList());
  }

  @Override
  public Publication createPublication(PublicationDTO publicationDTO) {

    Boolean successValidate = validateFields(publicationDTO);
    if (!successValidate) return null;

    Publication publication = new Publication(publications.size() + 1,
        publicationDTO.getUserId(),
        publicationDTO.getDate(),
        publicationDTO.getProductId(),
        publicationDTO.getCategory(),
        publicationDTO.getPrice(), publicationDTO.getHasPromo(), publicationDTO.getDiscount()
    );

    publications.add(publication);
    return publication;

  }

  private Boolean validateFields(PublicationDTO publicationDTO) {

    return publicationDTO.getUserId() != null &&
        publicationDTO.getDate() != null &&
        publicationDTO.getCategory() != null &&
        publicationDTO.getPrice() != null &&
        publicationDTO.getProductId() != null;

  }

}
