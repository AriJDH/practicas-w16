package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service that takes care of everything related to publishing
 */
@Service
public class PublicationService implements IPublicationService {

  @Autowired
  IPublicationRepository iPublicationRepository;
  @Autowired
  IUserService iUserService;

  @Autowired
  IProductService iProductService;

  /**
   * Method that returns the publications of the people I follow in date order.
   * @param userId Current user id
   * @param order Order of the list (ascending or descending)
   * @return DTO of a list of publications
   */
  @Override
  public ListProductByDateDTO getListProductByDate(Integer userId, String order) {

    List<User> users = iUserService.orderListUserFollowed(userId, "").getFollowed();
    List<Publication> sellers = getListSeller(users);
    List<PostDTO> listDTO = listOrderByWeekend(sellers);
    if (order.equals("date_desc")) {
      listDTO = listDTO.stream().sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList());
    }
    return new ListProductByDateDTO(userId, listDTO);
  }

  /**
   * Method to obtain the list of publications of the people I follow.
   * @param users List of users followed by the current user
   * @return List with the publications of the users I follow
   */
  private List<Publication> getListSeller(List<User> users) {
    List<Publication> sellers = new ArrayList<>();
    for (User user : users) {
      List<Publication> publications = iPublicationRepository.getListPublicationsById(user.getUserId());
      if (publications != null && publications.size() > 0) {
        sellers.addAll(publications);
      }
    }
    return sellers;
  }

  /**
   * Method that filters the list of products and obtains the products of the last two weeks.
   * @param publications List of publications of people followed by the current user
   * @return List of publications for the last two weeks
   */
  private List<PostDTO> listOrderByWeekend(List<Publication> publications) {
    LocalDate date = LocalDate.now().minusDays(15);
    List<PostDTO> result = publications.stream()
        .filter(x -> x.getDate().isAfter(date))
        .map(p -> new PostDTO(p.getPublicationId(), p.getUserId(),
            p.getDate(), iProductService.getProductById(p.getProductId()), p.getCategory(), p.getPrice()))
        .sorted(Comparator.comparing(PostDTO::getDate).reversed())
        .collect(Collectors.toList());

    return result;
  }


  /**
   * Method for creating a publication
   * @param requestCreatePublicationDTO DTO of a publication that is sent from request
   * @return Boolean that checks if the publication was created
   */
  @Override
  public Boolean createPublication(RequestCreatePublicationDTO requestCreatePublicationDTO) {

    PublicationDTO publicationDTO = new PublicationDTO(requestCreatePublicationDTO.getUserId(),
        requestCreatePublicationDTO.getDate(),
        requestCreatePublicationDTO.getCategory(),
        requestCreatePublicationDTO.getPrice(),
        requestCreatePublicationDTO.getProduct().getProductId());

    Publication publication = iPublicationRepository.createPublication(publicationDTO);

    return publication != null;
  }
}
