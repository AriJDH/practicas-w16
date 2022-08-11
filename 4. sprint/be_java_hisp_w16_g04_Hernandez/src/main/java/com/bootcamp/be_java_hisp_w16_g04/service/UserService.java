package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPromotionRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Method that takes care of everything related to the users.
 */
@Service
public class UserService implements IUserService {

  @Autowired
  IUserRepository iUserRepository;

  @Autowired
  IFollowerRepository iFollowerRepository;

  @Autowired
  IPromotionRepository iPromotionRepository;

  /**
   * Method to obtain a DTO with all the information of the followers of a user
   * @param userId Current user id
   * @param order Order in which the list will be submitted
   * @return DTO with the information of the users I follow
   */
  @Override
  public ResponseFollowersListDTO getListFollowersById(Integer userId, String order) {

    User user = iUserRepository.getByIdUser(userId);

    List<User> FollowerList = iFollowerRepository.getFollewersListById(userId).stream()
        .map(id -> iUserRepository.getByIdUser(id))
        .collect(Collectors.toList());

    if (order.equals("name_asc")) {
      FollowerList = FollowerList.stream()
          .sorted(Comparator.comparing(User::getUserName))
          .collect(Collectors.toList());
    } else if (order.equals("name_desc")) {
      FollowerList = FollowerList.stream()
          .sorted(Comparator.comparing(User::getUserName)
              .reversed())
              .collect(Collectors.toList());
    }

    //Fill data
    ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
    responseFollowersListDTO.setUserId(user.getUserId());
    responseFollowersListDTO.setUserName(user.getUserName());
    responseFollowersListDTO.setFollowers(FollowerList);

    return responseFollowersListDTO;
  }


  /**
   * Method that returns a DTO with the number of followers a user has.
   * @param userId Current user id
   * @return DTO with the information of followers that a user has
   */
  @Override
  public UserFollowersCountDTO followersCount(Integer userId) {

    User user = iUserRepository.getByIdUser(userId);
    List<Follower> followerList = iFollowerRepository.getFollowersByUserId(userId);

    if (user == null)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);

    return new UserFollowersCountDTO(user.getUserId(), user.getUserName(), followerList.size());
  }


  /**
   * Method that sorts the list of followers of a person
   * @param userId Current user id
   * @param order Order in which the list will be submitted
   * @return DTO with the list of all followers of a person
   */
  @Override
  public UserFollowedDTO orderListUserFollowed(Integer userId, String order) {

    UserFollowedDTO user = new UserFollowedDTO();
    User user1 = iUserRepository.getByIdUser(userId);

    if (user1 == null) {
      throw new UserNotFoundException("User Not Found with User Id: " + userId);
    }

    List<User> users = iFollowerRepository
        .returnIds(userId).stream()
        .map(id -> iUserRepository.getByIdUser(id))
        .collect(Collectors.toList());

    if (order.equals("name_asc")) {
      users = users.stream().sorted(Comparator.comparing(User::getUserName))
          .collect(Collectors.toList());
    } else if (order.equals("name_desc")) {
      users = users.stream().sorted(Comparator.comparing(User::getUserName)
              .reversed())
              .collect(Collectors.toList());
    }

    user.setFollowed(users);

    user.setUser_id(userId);
    user.setUser_name(user1.getUserName());

    return user;
  }

  /**
   * Method to obtain a DTO with the amount of promotions of a user
   * @param userId Current user id
   * @return DTO with the userId, UserName and number of products on promotion of a person
   */
  @Override
  public UserPromosCountDTO promosCount(Integer userId) {

    User user = iUserRepository.getByIdUser(userId);
    if (user == null)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);

    Long countPromosSeller = iPromotionRepository.getPromoByUserId(userId);

    UserPromosCountDTO userPromos = new UserPromosCountDTO();
    userPromos.setUserId(userId);
    userPromos.setUserName(user.getUserName());
    userPromos.setPromo_products_count(countPromosSeller);

    return userPromos;
  }

  /**
   * Method to obtain a DTO with all the information of the promotions of a user
   * @param userId Current user id
   * @return DTO with the userId, UserName and list of products on promotion of a person
   */
  @Override
  public PromotionDTO listProductsPromotion(Integer userId, String order) {

    User user = iUserRepository.getByIdUser(userId);
    if (user == null)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);

    List<Promotion> promotions = iPromotionRepository.getListPromosByUserId(userId);

    if (order.equals("price_asc")) {
      promotions = promotions.stream().sorted(Comparator.comparing(Promotion::getPrice))
              .collect(Collectors.toList());
    } else if (order.equals("price_desc")) {
      promotions = promotions.stream().sorted(Comparator.comparing(Promotion::getPrice)
              .reversed())
              .collect(Collectors.toList());
    }

    PromotionDTO promotionDTO = new PromotionDTO();
    promotionDTO.setUserId(userId);
    promotionDTO.setUserName(user.getUserName());
    promotionDTO.setPosts(promotions);

    return promotionDTO;
  }

}
