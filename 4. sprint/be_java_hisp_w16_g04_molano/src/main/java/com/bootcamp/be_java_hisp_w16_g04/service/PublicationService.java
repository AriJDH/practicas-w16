package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IProductRepository;
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
  IUserService iUserService;

  @Autowired
  IProductService iProductService;

  @Autowired
  IUserRepository iUserRepository;

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
        .map(p -> new PostDTO(p.getUserId(), p.getPublicationId(),
            p.getDate(), iProductService.getProductById(p.getProductId()), p.getCategory(), p.getPrice(),p.getHasPromo(), p.getDiscount()))
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
    Boolean hasPromo = false;
    Double discount = 0.0;
    if (requestCreatePublicationDTO.getHasPromo()) {
      hasPromo = true;
      discount = requestCreatePublicationDTO.getDiscount();
    }
    PublicationDTO publicationDTO = new PublicationDTO(requestCreatePublicationDTO.getUserId(),
        requestCreatePublicationDTO.getDate(),
        requestCreatePublicationDTO.getCategory(),
        requestCreatePublicationDTO.getPrice(),
        requestCreatePublicationDTO.getProduct().getProductId(), hasPromo, discount);

    Publication publication = iPublicationRepository.createPublication(publicationDTO);

    return publication != null;
  }

  /**
   * Method in charge of obtaining all the products in promotion from the current user
   * @param userId current user id
   * @return DTO with the information of all the products in promotion of a user
   */
  @Override
  public ProductsUserPromotionsDTO promoProductsByUserId(Integer userId) {
    User currentUser = iUserRepository.getByIdUser(userId);
    List<PostDTO> publicationList = iPublicationRepository.getListPublicationsById(userId)
        .stream()
        .filter(Publication::getHasPromo)
        .map(p -> new PostDTO(p.getUserId(), p.getPublicationId(), p.getDate(),
            iProductService.getProductById(p.getProductId()), p.getCategory(),
            p.getPrice(), p.getHasPromo(), p.getDiscount()))
        .collect(Collectors.toList());

    return new ProductsUserPromotionsDTO(userId, currentUser.getUserName(), publicationList);
  }

  /**
   * Method in charge of obtaining all the products that are on discount at the moment
   * (You can send a param query to sort).
   * @param order Order in which the discounted products will be displayed
   * @return DTO with all the information of the products in discount
   */
  @Override
  public AllPromoPublicationDTO allPromoPublications(String order) {
    Comparator<PostDTO> newOrder = Comparator.comparing(PostDTO::getDiscount);
    if(order.equals("desc")) newOrder = Comparator.comparing(PostDTO::getDiscount).reversed();
    List<PostDTO> post = iPublicationRepository.getPublications()
        .stream()
        .filter(Publication::getHasPromo)
        .map(p -> new PostDTO(p.getUserId(), p.getPublicationId(), p.getDate(),
            iProductService.getProductById(p.getProductId()), p.getCategory(),
            p.getPrice(), p.getHasPromo(), p.getDiscount()))
        .sorted(newOrder)
        .collect(Collectors.toList());

    return new AllPromoPublicationDTO(post);
  }
}
