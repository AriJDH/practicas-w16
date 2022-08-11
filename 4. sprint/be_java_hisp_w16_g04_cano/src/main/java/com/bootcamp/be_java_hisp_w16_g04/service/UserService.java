package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g04.repositories.FollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Method that takes care of everything related to the users.
 */
@Service
public class UserService implements IUserService {

  private final IUserRepository iUserRepository;

  private final IFollowerRepository iFollowerRepository;

  public UserService(FollowerRepository followerRepository, UserRepository userRepository) {
    this.iUserRepository = userRepository;
    this.iFollowerRepository = followerRepository;
  }

  /**
   * Method to obtain a DTO with all the information of the followers of a user
   * @param userId Current user id
   * @param order Order in which the list will be submitted
   * @return DTO with the information of the users I follow
   */
  @Override
  public ResponseFollowersListDTO getListFollowersById(Integer userId, String order) {

    isValidUser(userId);
    User user = iUserRepository.getByIdUser(userId);

    List<User> FollowerList = iFollowerRepository.getFollowersListById(userId).stream()
        .map(iUserRepository::getByIdUser)
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

    isValidUser(userId);
    User user = iUserRepository.getByIdUser(userId);
    List<Follower> followerList = iFollowerRepository.getFollowersByUserId(userId);

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
    isValidUser(userId);
    User user1 = iUserRepository.getByIdUser(userId);

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

  @Override
  public void isValidUser(Integer userId) {
    boolean result = iUserRepository.isValidUser(userId);

    if(!result)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);
  }

}
