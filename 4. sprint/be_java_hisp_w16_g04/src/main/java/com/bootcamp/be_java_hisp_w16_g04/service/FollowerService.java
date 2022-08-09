package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserIlegalFollow;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService implements IFollowerService {

  @Autowired
  IFollowerRepository ifollowerRepository;


  @Override
  public FollowUserDTO followUser(Integer userId, Integer userIdToFollow) {
    Boolean verifyFollower = ifollowerRepository.verifyFollower(userIdToFollow, userId);

    if (!verifyFollower) {
      throw new UserIlegalFollow("The user already follows the seller");
    }

    ifollowerRepository.followUser(userIdToFollow, userId);

    return new FollowUserDTO("Successful follow-up");
  }


}
