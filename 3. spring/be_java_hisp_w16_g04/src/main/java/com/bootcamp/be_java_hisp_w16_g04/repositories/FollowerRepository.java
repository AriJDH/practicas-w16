package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

}
