package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
  IUserRepository iUserRepository;
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
   * Method that returns the list promo publication by user
   * @param userId user identification
   * @return DTO of a list og promo publication
   */
  @Override
  public ResponseListPromoPublicationDTO getListPromoPublication(Integer userId) {
    //Get User
    User user = iUserRepository.getByIdUser(userId);
    if (user == null) throw new UserNotFoundException("User Not Found with User Id: " + userId);

    //Get list of publication with promo.
   List<PromoPublicationDTO> listPublications = iPublicationRepository.getListPromoPublicationById(userId);
    return new ResponseListPromoPublicationDTO(user.getUserId(),user.getUserName(),listPublications);
  }
  /**
   * Method that returns number promo publication by user
   * @param userId user identification
   * @return DTO of a count of promo publication
   */
  @Override
  public ResponseNumberPromoProductsDTO getNumberPromoPublicationById(Integer userId) {
    //Get User
    User user = iUserRepository.getByIdUser(userId);
    if (user == null) throw new UserNotFoundException("User Not Found with User Id: " + userId);

    //Get list of publication with promo.
    List<PromoPublicationDTO> listPublications = iPublicationRepository.getListPromoPublicationById(userId);
    return new ResponseNumberPromoProductsDTO(user.getUserId(),user.getUserName(),listPublications.size());
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

    return publications.stream()
        .filter(x -> x.getDate().isAfter(date))
        .map(p -> new PostDTO(p.getPublicationId(), p.getUserId(),
            p.getDate(), iProductService.getProductById(p.getProductId()), p.getCategory(), p.getPrice()))
        .sorted(Comparator.comparing(PostDTO::getDate).reversed())
        .collect(Collectors.toList());
  }


}
