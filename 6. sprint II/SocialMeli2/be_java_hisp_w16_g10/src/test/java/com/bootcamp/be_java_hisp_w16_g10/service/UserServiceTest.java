package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.repository.UserRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

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
    void shouldReturnBadRequestExceptionIsNotSellerInListFollowers() {
        //arrange
        var user = generateUser(1);

        //act
        when(userRepository.findById(1)).thenReturn(user);
        when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

        //assert
        assertThrows(BadRequestException.class, () -> userService.listFollowers(1,""));
    }

    @Test
    void shouldReturnBadRequestExceptionInvalidOrderInListFollowers() {
        //arrange
        var user = generateUser(1);

        //act
        when(userRepository.findById(1)).thenReturn(user);
        when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

        //assert
        assertThrows(BadRequestException.class, () -> userService.listFollowers(1,"papa"));
    }

    @Test
    void shouldReturnBadRequestExceptionOrderAscInListFollowers() {
        //arrange
        var user = generateUserWithFollowers(1);

        var expected = Mapper.parseToFollowersListResDTO(user,user.getFollowers().stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList()));

        //act
        when(userRepository.findById(1)).thenReturn(user);

        when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

        //assert
        assertEquals(expected,userService.listFollowers(1,"name_asc"));
    }

    @Test
    void shouldReturnBadRequestExceptionOrderDescInListFollowers() {
        //arrange
        var user = generateUserWithFollowers(1);

        var expected = Mapper.parseToFollowersListResDTO(user,user.getFollowers().stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList()));

        //act
        when(userRepository.findById(1)).thenReturn(user);

        when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

        //assert
        assertEquals(expected,userService.listFollowers(1,"name_desc"));
    }

    @Test
    void shouldReturnBadRequestExceptionInvalidOrderInListFollowed() {
        //arrange
        var user = generateUser(1);

        //act
        when(userRepository.findById(1)).thenReturn(user);

        //assert
        assertThrows(BadRequestException.class, () -> userService.listFollowed(1,"papa"));
    }

    @Test
    void shouldReturnBadRequestExceptionOrderAscInListFollowed() {
        //arrange
        var user = generateUserWithFollowed(1);

        var expected = Mapper.parseToFollowedListResDTO(user,user.getFollowed().stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList()));

        //act
        when(userRepository.findById(1)).thenReturn(user);

        //assert
        assertEquals(expected,userService.listFollowed(1,"name_asc"));
    }

    @Test
    void shouldReturnBadRequestExceptionOrderDescInListFollowed() {
        //arrange
        var user = generateUserWithFollowed(1);

        var expected = Mapper.parseToFollowedListResDTO(user,user.getFollowed().stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList()));

        //act
        when(userRepository.findById(1)).thenReturn(user);

        //assert
        assertEquals(expected,userService.listFollowed(1,"name_desc"));
    }
}