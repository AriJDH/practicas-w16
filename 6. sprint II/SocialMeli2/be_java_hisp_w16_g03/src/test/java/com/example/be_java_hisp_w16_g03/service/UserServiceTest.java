package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService userService;

    @Test
    public void getcountFollowersTest(){
        User user=new User();
        user.setUserId(1);
        user.setUserName("emanuel");
        User userFollower=new User();
        userFollower.setUserId(2);
        userFollower.setUserName("juan");
        List<User> followers= Arrays.asList(userFollower);
        user.setFollowers(followers);
        when(repository.getUserById(1)).thenReturn(Optional.of(user));


        FollowerCountDTO followerCountDTO=userService.getCountFollowers(1);

        Assertions.assertEquals(user.getFollowers().size(),followerCountDTO.getFollowersCount());
        Assertions.assertEquals(user.getUserName(),followerCountDTO.getUserName());
        Assertions.assertEquals(user.getUserId(),followerCountDTO.getUserId());
    }



}
