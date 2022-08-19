package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
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
}