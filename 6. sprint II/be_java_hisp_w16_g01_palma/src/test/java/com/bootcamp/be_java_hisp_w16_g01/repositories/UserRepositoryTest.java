package com.bootcamp.be_java_hisp_w16_g01.repositories;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.repository.UserRepository;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
        assertNotNull(usr1);
        assertEquals(idUser, usr1.getUserId());
    }

    @Test
    public void getUserNullTest() {
        Integer idUser = null;
        User usr1 = repository.getUser(idUser);
        assertNull(usr1);
    }

    @Test
    public void userIsFollowedTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollowed = repository.userIsFollowed(usr1, usr2);
        assertTrue(isFollowed);
    }

    @Test
    public void userIsNotFollowedTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollowed = repository.userIsFollowed(usr2, usr1);
        assertFalse(isFollowed);
    }

    @Test
    public void userIsNotFollowerTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollower = repository.userIsFollower(usr1, usr2);
        assertFalse(isFollower);
    }

    @Test
    public void userIsFollowerTest() {
        Integer idUser1 = 1;
        Integer idUser2 = 2;
        User usr1 = repository.getUser(idUser1);
        User usr2 = repository.getUser(idUser2);
        boolean isFollower = repository.userIsFollower(usr2, usr1);
        assertTrue(isFollower);
    }

    @Test
    public void getUserInvalidTest() {
        User user10 = new User(10, "Usuario10", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // assert
        assertNull(repository.getUser(user10.getUserId()));

    }

    @Test
    @DisplayName("El usuario existe")
    public void userExistsTest() {
        //Arrange
        Integer userId = 1;
        //Act
        boolean result = repository.userExists(userId);
        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("El usuario no existe")
    public void userNotExistsTest() {
        //Arrange
        Integer userId = 999;
        //Act
        boolean result = repository.userExists(userId);
        //Assert
        assertFalse(result);
    }

    @Test
    public void userIsSellerTest() {
        // Arrange
        User user = repository.getUser(1);
        user.addPost(new Post());
        boolean expected = true;

        // Act
        boolean result = repository.userIsSeller(user.getUserId());
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void userIsNotSellerTest() {
        // Arrange
        User user = repository.getUser(1);

        boolean expected = false;

        // Act
        boolean result = repository.userIsSeller(user.getUserId());
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void addFollowedTest() {
        //Arrange
        User userFollows = repository.getUser(4);
        User userToFollow = repository.getUser(5);

        // Act
        repository.addFollowed(userFollows.getUserId(), userToFollow.getUserId());

        // Assert
        assertTrue(userFollows.getFollowed().contains(userToFollow));
    }

    @Test
    public void addFollowerTest() {
        //Arrange
        User userFollows = repository.getUser(4);
        User userToFollow = repository.getUser(5);

        // Act
        repository.addFollower(userFollows.getUserId(), userToFollow.getUserId());

        // Assert
        assertTrue(userToFollow.getFollowers().contains(userFollows));
    }
}
