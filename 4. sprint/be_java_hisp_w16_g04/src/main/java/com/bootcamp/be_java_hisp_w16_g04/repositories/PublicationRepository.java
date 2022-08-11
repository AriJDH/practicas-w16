package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.PromoPublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationCreateDTO;
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

    publications.add(new Publication(1, 104, date1, 100, 100, 0.0,0.0,false));
    publications.add(new Publication(2, 104, date2, 200, 200, 0.5,350.0,true));
    publications.add(new Publication(2, 104, date3, 300, 200, 1.0,350.0,true));
  }

  @Override
  public List<Publication> getPublications() {
    return publications;
  }

  @Override
  public List<Publication> getListPublicationsById(Integer userId) {
    return publications.stream().filter(x -> x.getUserId()
            .equals(userId))
            .collect(Collectors.toList());
  }

  @Override
  public Publication createPublication(PublicationCreateDTO publicationDTO) {

    Boolean successValidate = validateFields(publicationDTO);
    if (!successValidate) return null;

    Publication publication = new Publication(publications.size() + 1,
        publicationDTO.getUserId(),
        publicationDTO.getDate(),
        publicationDTO.getProductId(),
        publicationDTO.getCategory(),
        publicationDTO.getDiscount(),
        publicationDTO.getPrice(),
        publicationDTO.getHasPromo());

    publications.add(publication);
    return publication;
  }

  @Override
  public List<PromoPublicationDTO> getListPromoPublicationById(Integer userId) {
    return publications.stream()
            .filter(x -> x.getUserId().equals(userId) && x.getHasPromo() )
            .map(pb -> new PromoPublicationDTO(pb.getPublicationId(),
                    pb.getUserId(),
                    pb.getDate(),
                    pb.getProductId(),
                    pb.getCategory(),
                    pb.getDiscount(),
                    pb.getHasPromo(),
                    pb.getPrice()
                    ))
            .collect(Collectors.toList());
  }

  private Boolean validateFields(PublicationCreateDTO publicationDTO) {

    return publicationDTO.getUserId() != null &&
        publicationDTO.getDate() != null &&
        publicationDTO.getCategory() != null &&
        publicationDTO.getPrice() != null &&
        publicationDTO.getProductId() != null;

  }

}
