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
    FollowerRepository FollowerRepository;

    @Autowired
    IFollowerRepository iFollowerRepository;

    @Test
    public void verifyFollowerTestTrue() {
        List<Follower> followers = TestUtilsGenerator.createListFollowers();

        FollowerRepository.setFollowers(followers);

        Assertions.assertTrue(iFollowerRepository.verifyFollower(105, 102));
    }

    @Test
    public void verifyFollowerTestFalse() {
        List<Follower> followers = TestUtilsGenerator.createListFollowers();

        FollowerRepository.setFollowers(followers);

        Assertions.assertFalse(iFollowerRepository.verifyFollower(101, 103));
    }

    @Test
    public void getFollewersListByIdTest() {
        List<Follower> followers = TestUtilsGenerator.createListFollowers();
        FollowerRepository.setFollowers(followers);

        List<Integer> result = iFollowerRepository.getFollewersListById(101);

        Assertions.assertNotNull(result, "La prueba fue exitosa");
    }
}
