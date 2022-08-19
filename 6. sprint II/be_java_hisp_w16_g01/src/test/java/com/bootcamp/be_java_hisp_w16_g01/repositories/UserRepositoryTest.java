package com.bootcamp.be_java_hisp_w16_g01.repositories;

import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    UserRepository repository;

    @BeforeEach
    public void emptyRepo(){
        this.repository = new UserRepository();
    }

    @Test
    void userIsSeller() {
        // Arrange
        User user = this.repository.getUser(1);
        user.addPost(new Post());
        boolean expected = true;

        // Act
        boolean result = this.repository.userIsSeller(user.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }
    @Test
    void userIsNotSeller() {
        // Arrange
        User user = this.repository.getUser(1);

        boolean expected = false;

        // Act
        boolean result = this.repository.userIsSeller(user.getUserId());
        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void userExists() {
        // Arrange
        User user = this.repository.getUser(1);
        boolean expected = true;

        // Act
        boolean result = this.repository.userExists(user.getUserId());

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void userDoesNotExists() {
        // Arrange
        User user = new User(10, "Jose");
        boolean expected = false;

        // Act
        boolean result = this.repository.userExists(user.getUserId());

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void addFollowed() {
        //Arrange
        User userFollows = this.repository.getUser(1);
        User userToFollow = this.repository.getUser(2);

        // Act
        this.repository.addFollowed(userFollows.getUserId(), userToFollow.getUserId());

        // Assert
        Assertions.assertTrue(userFollows.getFollowed().contains(userToFollow));
    }
    @Test
    void addFollower() {
        //Arrange
        User userFollows = this.repository.getUser(1);
        User userToFollow = this.repository.getUser(2);

        // Act
        this.repository.addFollower(userFollows.getUserId(), userToFollow.getUserId());

        // Assert
        Assertions.assertTrue(userToFollow.getFollowers().contains(userFollows));
    }
}
