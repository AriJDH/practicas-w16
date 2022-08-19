package com.bootcamp.be_java_hisp_w16_g01.repositories;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.ArrayList;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    UserRepository repository;

    private List<User> userList = FactoryUser.getMockedUsers();

    @BeforeEach
    public void emptyRepo() {
        this.repository = new UserRepository(userList);
    }

    @Test
    public void getUserTest() {
        Integer idUser = 1;
        User usr1 = repository.getUser(idUser);
        Assertions.assertNotNull(usr1);
        Assertions.assertEquals(idUser, usr1.getUserId());
    }

    @Test
    public void getUserNullTest() {
        Integer idUser = null;
        User usr1 = repository.getUser(idUser);
        Assertions.assertNull(usr1);
    }

    @Test
    public void userIsFollowedTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollowed = repository.userIsFollowed(usr1, usr2);
        Assertions.assertTrue(isFollowed);
    }

    @Test
    public void userIsNotFollowedTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollowed = repository.userIsFollowed(usr2, usr1);
        Assertions.assertFalse(isFollowed);
    }

    @Test
    public void userIsNotFollowerTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollowed = repository.userIsFollower(usr1, usr2);
        Assertions.assertFalse(isFollowed);
    }

    @Test
    public void userIsFollowerTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollowed = repository.userIsFollower(usr2, usr1);
        Assertions.assertTrue(isFollowed);
    }

    @Test
    public void getUserInvalidTest() {
        User user10 = new User(10, "Usuario10", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // assert
        Assertions.assertNull(repository.getUser(user10.getUserId()));
    }

    @Test
    void userIsSeller() {
        // Arrange
        User user = repository.getUser(1);
        user.addPost(new Post());
        boolean expected = true;

        // Act
        boolean result = repository.userIsSeller(user.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void userIsNotSeller() {
        // Arrange
        User user = repository.getUser(1);

        boolean expected = false;

        // Act
        boolean result = repository.userIsSeller(user.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void addFollowed() {
        //Arrange
        User userFollows = repository.getUser(4);
        User userToFollow = repository.getUser(5);

        // Act
        repository.addFollowed(userFollows.getUserId(), userToFollow.getUserId());

        // Assert
        Assertions.assertTrue(userFollows.getFollowed().contains(userToFollow));
    }

    @Test
    void addFollower() {
        //Arrange
        User userFollows = repository.getUser(4);
        User userToFollow = repository.getUser(5);

        // Act
        repository.addFollower(userFollows.getUserId(), userToFollow.getUserId());

        // Assert
        Assertions.assertTrue(userToFollow.getFollowers().contains(userFollows));
    }
}
