package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FollowerRepository implements IFollowerRepository{
  List<Follower> followers = new ArrayList<Follower>();

  @PostConstruct
  private void loadData(){
    followers.add(new Follower(100, 101));
    followers.add(new Follower(100, 102));
    followers.add(new Follower(100, 103));
    followers.add(new Follower(104, 105));
    followers.add(new Follower(104, 106));
  }

  @Override
  public void followUser(Integer userIdToFollow, Integer  userId) {
    followers.add(new Follower(userIdToFollow, userId));
  }

  @Override
  public Boolean verifyFollower(Integer userIdToFollow, Integer userId) {
    Long countFollow = followers.stream()
        .filter(follower -> follower.getIdUser().equals(userIdToFollow) && follower.getIdFollower().equals(userId))
        .count();

    if (countFollow > 0) {
      return false;
    }
    return true;
  }

  @Override
  public List<Follower> getFollowersByUserId(Integer userId) {
    return followers.stream().filter(x -> x.getIdUser().equals(userId)).collect(Collectors.toList());
  }
}
