package com.bootcamp.be_java_hisp_w16_g04.Repository;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.repositories.FollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FollowerRepositoryTest {

  @Autowired
  FollowerRepository followerRepository;

  @Autowired
  IFollowerRepository iFollowerRepository;

  @Test
  public void verifyFollowerTestFalse() {
    List<Follower> followers = TestUtilsGenerator.createListFollowers();

    followerRepository.setFollowers(followers);

    Assertions.assertTrue(iFollowerRepository.verifyFollower(105, 102));
  }

  @Test
  public void verifyFollowerTestTrue() {
    List<Follower> followers = TestUtilsGenerator.createListFollowers();

    followerRepository.setFollowers(followers);

    Assertions.assertFalse(iFollowerRepository.verifyFollower(101, 103));
  }

  @Test
  public void getFollewersListByIdTest() {
    List<Follower> followers = TestUtilsGenerator.createListFollowers();
    followerRepository.setFollowers(followers);

    List<Integer> result = followerRepository.getFollewersListById(101);

    Assertions.assertNotNull(result, "La prueba fue exitosa");
  }

  @Test
  public void getReturnIdsFollowersTest() {
    List<Follower> followers = TestUtilsGenerator.createListFollowers();
    followerRepository.setFollowers(followers);

    List<Integer> result = followerRepository.returnIds(101);

    Assertions.assertEquals(2, result.size());
  }

  @Test
  public void unFollowUserTest() {
    List<Follower> followers = TestUtilsGenerator.createListFollowers();
    followerRepository.setFollowers(followers);

    followerRepository.unFollowUser(105, 101);

    List<Integer> result = followerRepository.returnIds(101);

    Assertions.assertEquals(1, result.size());
  }
}
