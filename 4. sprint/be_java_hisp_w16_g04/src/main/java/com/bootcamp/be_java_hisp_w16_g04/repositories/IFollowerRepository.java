package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;

import java.util.List;

public interface IFollowerRepository {
  void followUser(Integer userId, Integer userIdToFollow);

  Boolean verifyFollower(Integer userId, Integer userIdToFollow);
    List<Follower> getFollowersByUserId(Integer userId);
}
