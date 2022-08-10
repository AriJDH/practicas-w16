package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FollowerRepository implements IFollowerRepository {
  List<Follower> followers = new ArrayList<Follower>();

  @PostConstruct
  private void loadData() {
    followers.add(new Follower(100, 101));
    followers.add(new Follower(100, 105));
    followers.add(new Follower(100, 103));
    followers.add(new Follower(104, 105));
    followers.add(new Follower(104, 106));
    followers.add(new Follower(100, 106));
  }

  @Override
  public List<Integer> getFollewersListById(Integer userId) {
    return followers.stream().filter(follower -> follower.getIdUser().equals(userId))
        .map(Follower::getIdFollower)
        .collect(Collectors.toList());
  }

  @Override
  public void followUser(Integer userIdToFollow, Integer userId) {
    followers.add(new Follower(userIdToFollow, userId));
  }

  @Override
  public Boolean verifyFollower(Integer userIdToFollow, Integer userId) {
    Long countFollow = followers.stream()
        .filter(follower -> follower.getIdUser().equals(userIdToFollow) && follower.getIdFollower().equals(userId))
        .count();

    return !(countFollow > 0);
  }

  @Override
  public List<Follower> getFollowersByUserId(Integer userId) {
    return followers.stream().filter(x -> x.getIdUser().equals(userId)).collect(Collectors.toList());
  }

  @Override
  public List<Integer> returnIds(Integer userId) {
    List<Integer> ids = new ArrayList<>();
    followers.stream()
        .filter(user -> user.getIdFollower() == userId)
        .collect(Collectors.toList())
        .forEach(follower -> ids.add(follower.getIdUser()));
    return ids;
  }

  @Override
  public void unFollowUser(Integer userIdToUnfollow, Integer userId) {
    followers = followers.stream()
        .filter(follower -> !(follower.getIdUser().equals(userIdToUnfollow) && follower.getIdFollower().equals(userId)))
        .collect(Collectors.toList());

  }
}
