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
    String dateString1 = LocalDate.now().minusDays(8).format(dtf);
    String dateString2 = LocalDate.now().minusDays(12).format(dtf);
    String dateString3 = LocalDate.now().minusDays(30).format(dtf);
    LocalDate date1 = LocalDate.parse(dateString1, dtf);
    LocalDate date2 = LocalDate.parse(dateString2, dtf);
    LocalDate date3 = LocalDate.parse(dateString3, dtf);

    publications.add(new Publication(1, 104, date1, 100, 100, 150.0));
    publications.add(new Publication(2, 104, date2, 200, 200, 350.0));
    publications.add(new Publication(2, 104, date3, 300, 200, 350.0));
  }

  public void setPublications(List<Publication> publications) {
    this.publications = publications;
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
  public Publication createPublication(PublicationDTO publicationDTO) {

    Boolean successValidate = validateFields(publicationDTO);
    if (!successValidate) return null;

    Publication publication = new Publication(publications.size() + 1,
        publicationDTO.getUserId(),
        publicationDTO.getDate(),
        publicationDTO.getProductId(),
        publicationDTO.getCategory(),
        publicationDTO.getPrice());

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
