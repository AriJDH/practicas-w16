package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidOrderException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

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

    //T-0003
    @Test
    public void correctOrderValueFollowedsTest(){
        Integer userId = 1;
        String incorrectOrder = "name_asc";
        User user = new User(userId, "userName");
        when(repository.getUserById(userId)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.getFollowedUsers(userId, incorrectOrder));
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    //T-0003
    @Test
    public void incorrectOrderValueFollowedsTest(){
        Integer userId = 1;
        String incorrectOrder = "WRONG";
        User user = new User(userId, "userName");
        when(repository.getUserById(userId)).thenReturn(Optional.of(user));

        assertThrows(InvalidOrderException.class, () -> userService.getFollowedUsers(userId, incorrectOrder));
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    //T-0003
    @Test
    public void correctOrderValueFollowersTest(){
        Integer userId = 1;
        String incorrectOrder = "name_asc";
        User user = new User(userId, "userName");
        when(repository.getUserById(userId)).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.getFollowers(userId, incorrectOrder));
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    //T-0003
    @Test
    public void incorrectOrderValueFollowersTest(){
        Integer userId = 1;
        String incorrectOrder = "WRONG";
        User user = new User(userId, "userName");
        when(repository.getUserById(userId)).thenReturn(Optional.of(user));

        assertThrows(InvalidOrderException.class, () -> userService.getFollowers(userId, incorrectOrder));
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }


    //T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    @Test
    public void correctOrderAscFollowedsTest(){
        Integer userId = 1;
        String order = "name_asc";
        User user1 = new User(userId, "userName");
        User user2 = new User(2, "Alberto");
        User user3 = new User(3, "Briant");
        User user4 = new User(4, "Carlos");
        List<User> followeds = new ArrayList<>();
        followeds.add(user4);
        followeds.add(user3);
        followeds.add(user2);
        user1.setFolloweds(followeds);
        when(repository.getUserById(userId)).thenReturn(Optional.of(user1));

        FollowedsDTO followedsDTO = userService.getFollowedUsers(userId, order);

        Assertions.assertEquals("Alberto", followedsDTO.getFollowed().get(0).getUserName());
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    //T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    @Test
    public void correctOrderDescFollowedsTest(){
        Integer userId = 1;
        String order = "name_desc";
        User user1 = new User(userId, "userName");
        User user2 = new User(2, "Alberto");
        User user3 = new User(3, "Briant");
        User user4 = new User(4, "Carlos");
        List<User> followeds = new ArrayList<>();
        followeds.add(user2);
        followeds.add(user3);
        followeds.add(user4);
        user1.setFolloweds(followeds);
        when(repository.getUserById(userId)).thenReturn(Optional.of(user1));

        FollowedsDTO followedsDTO = userService.getFollowedUsers(userId, order);

        Assertions.assertEquals("Carlos", followedsDTO.getFollowed().get(0).getUserName());
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    //T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    @Test
    public void correctOrderAscFollowersTest(){
        Integer userId = 1;
        String order = "name_asc";
        User user1 = new User(userId, "userName");
        User user2 = new User(2, "Alberto");
        User user3 = new User(3, "Briant");
        User user4 = new User(4, "Carlos");
        List<User> followeds = new ArrayList<>();
        followeds.add(user4);
        followeds.add(user3);
        followeds.add(user2);
        user1.setFollowers(followeds);
        when(repository.getUserById(userId)).thenReturn(Optional.of(user1));

        FollowersDTO followersDTO = userService.getFollowers(userId, order);

        Assertions.assertEquals("Alberto", followersDTO.getFollowers().get(0).getUserName());
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

    //T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
    @Test
    public void correctOrderDescFollowersTest(){
        Integer userId = 1;
        String order = "name_desc";
        User user1 = new User(userId, "userName");
        User user2 = new User(2, "Alberto");
        User user3 = new User(3, "Briant");
        User user4 = new User(4, "Carlos");
        List<User> followeds = new ArrayList<>();
        followeds.add(user2);
        followeds.add(user3);
        followeds.add(user4);
        user1.setFollowers(followeds);
        when(repository.getUserById(userId)).thenReturn(Optional.of(user1));

        FollowersDTO followersDTO = userService.getFollowers(userId, order);

        Assertions.assertEquals("Carlos", followersDTO.getFollowers().get(0).getUserName());
        Mockito.verify(repository, Mockito.times(1)).getUserById(userId);
    }

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
