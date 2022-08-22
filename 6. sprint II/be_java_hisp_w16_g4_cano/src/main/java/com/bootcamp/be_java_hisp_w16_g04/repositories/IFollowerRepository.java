package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;

import java.util.List;

public interface IFollowerRepository {
  List<Integer> getFollewersListById(Integer userId);

  void followUser(Integer userId, Integer userIdToFollow);

  Boolean verifyFollower(Integer userId, Integer userIdToFollow);

  List<Follower> getFollowersByUserId(Integer userId);

  List<Integer> returnIds(Integer userId);

  void unFollowUser(Integer userIdToUnfollow, Integer userId);
}
