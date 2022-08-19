package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.bootcamp.be_java_hisp_w16_g10.util.Factory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    PostService postService;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void follow() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void validateUserNotFoundCountFollowers() {
        //assert
        assertThrows(NotFoundException.class, () -> {
            when(userService.countFollowers(anyInt())).thenReturn(null);
        });
    }

    @Test
    void shouldReturnCountFollowers() {
        //arrange
        var user = generateUser(1);
        //act

        when(userRepository.findById(1)).thenReturn(user);
        when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

        var res = userService.countFollowers(1);

        //assert
        assertEquals(0,res.getFollowersCount());

    }

    @Test
    void shouldReturnBadRequestExceptionInCountFollowers() {
        //arrange
        var user = generateUser(1);

        //act
        when(userRepository.findById(1)).thenReturn(user);
        when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

        //assert
        assertThrows(BadRequestException.class, () -> userService.countFollowers(1));
    }

    @Test
    void listFollowers() {
    }

    @Test
    void listFollowed() {
    }
}