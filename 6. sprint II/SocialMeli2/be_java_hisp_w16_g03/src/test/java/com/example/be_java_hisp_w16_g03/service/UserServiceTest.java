package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService userService;

    @DisplayName("Users exist when following")
    @Test
    void test1() {

        //arrange
        User user1 = new User(1, "Pablo");
        User user2 = new User(2, "Lucas");
        user2.getPosts().add(new Post());
        Optional<User> user1Optional = Optional.of(user1);
        Optional<User> user2Optional = Optional.of(user2);

        when(repository.getUserById(Mockito.anyInt())).thenReturn(user1Optional, user2Optional);

        //act
        userService.followUser(user1.getUserId(), user2.getUserId());

        //assert
        Assertions.assertTrue(user2.getFollowers().contains(user1) && user1.getFolloweds().contains(user2));
    }

    @DisplayName("FollowUser throws exception when users dont exist")
    @Test
    void test2() {

        //arrange
        User user1 = new User(1, "Pablo");
        User user2 = new User(2, "Lucas");
        Optional<User> user1Optional = Optional.of(user1);

        when(repository.getUserById(1)).thenReturn(user1Optional);

        //act
        //assert
        Assertions.assertThrows(UserNotExistException.class, () -> userService.followUser(user1.getUserId(), user2.getUserId()));
    }

    @DisplayName("Users exist when unfollowing")
    @Test
    void test3() {

        //arrange
        User user1 = new User(1, "Pablo");
        User user2 = new User(2, "Lucas");
        user2.getPosts().add(new Post());
        user1.getFolloweds().add(user2);
        user2.getFollowers().add(user1);
        Optional<User> user1Optional = Optional.of(user1);
        Optional<User> user2Optional = Optional.of(user2);

        when(repository.getUserById(Mockito.anyInt())).thenReturn(user1Optional, user2Optional);

        //act
        userService.unfollowUser(user1.getUserId(), user2.getUserId());

        //assert
        Assertions.assertTrue(!user2.getFollowers().contains(user1) && !user1.getFolloweds().contains(user2));
    }

    @DisplayName("UnfollowUser throws exception when users dont exist")
    @Test
    void test4() {

        //arrange
        User user1 = new User(1, "Pablo");
        User user2 = new User(2, "Lucas");
        Optional<User> user1Optional = Optional.of(user1);
        Optional<User> user2Optional = Optional.of(user2);

        when(repository.getUserById(1)).thenReturn(user1Optional);

        //act
        //assert
        Assertions.assertThrows(UserNotExistException.class, () -> userService.unfollowUser(user1.getUserId(), user2.getUserId()));
    }


}