package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserIlegalFollow;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service takes care of everything related to followers
 */
@Service
public class FollowerService implements IFollowerService {

  @Autowired
  IFollowerRepository ifollowerRepository;

  @Autowired
  IUserRepository iUserRepository;

  /**
   * This method is responsible for creating a record of a user following another user
   * @param userId Is the id of the current user
   * @param userIdToFollow This is the user id of the user to be tracked
   * @return Returns a DTO where with a correct or incorrect action message
   */
  @Override
  public FollowUserDTO followUser(Integer userId, Integer userIdToFollow) {
    isValidUser(userId);
    isValidUser(userIdToFollow);

    Boolean verifyFollower = ifollowerRepository.verifyFollower(userIdToFollow, userId);

    if (!verifyFollower) {
      throw new UserIlegalFollow("The user already follows the seller");
    }

    ifollowerRepository.followUser(userIdToFollow, userId);

    return new FollowUserDTO("Successful follow-up");
  }

  /**
   * This method is used when a user unfollows another user.
   * @param userId Is the id of the current user
   * @param userIdToUnfollow This is the user id of the user to be tracked
   * @return Returns a DTO where with a correct or incorrect action message
   */
  @Override
  public FollowUserDTO unFollowUser(Integer userId, Integer userIdToUnfollow) {
    isValidUser(userIdToUnfollow);
    isValidUser(userId);
    ifollowerRepository.unFollowUser(userIdToUnfollow, userId);
    return new FollowUserDTO("Unfollow successful");
  }

  public void isValidUser(Integer userId) {
    boolean result = iUserRepository.isValidUser(userId);

    if(!result)
      throw new UserNotFoundException("User Not Found with User Id: " + userId);
  }
}
