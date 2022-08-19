package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
import com.bootcamp.be_java_hisp_w16_g7.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    IUserService userService;

    @InjectMocks
    UserController userController;

    //Test

    @Test
    public void getUserFollowedListNonexistentUser() {
        int id = 5;
        when(userService.getUserFollowedList(id, null)).thenThrow(new UserNotFoundException(id));

        assertThrows(UserNotFoundException.class, () -> userController.getUserFollowedList(id, null));
        verify(userService, atLeastOnce()).getUserFollowedList(id, null);
    }

    @Test
    public void getUserFollowedListExistingUser() {
        ResponseUserFollowedDTO user = TestUtil.createUserDTOFollowedTest();
        when(userService.getUserFollowedList(user.getUserId(), null)).thenReturn(user);

        ResponseEntity<ResponseUserFollowedDTO> response = userController.getUserFollowedList(user.getUserId(), null);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, atLeastOnce()).getUserFollowedList(user.getUserId(), null);
    }

    @Test
    public void followExistingUser() {
        int id = 1, idToFollow = 2;
        ApiResponseDto expected = new ApiResponseDto("Follow user",
                "User with id " + id + " has followed user with id " + idToFollow);
        when(userService.follow(id, idToFollow)).thenReturn(expected);

        ResponseEntity<ApiResponseDto> response = userController.follow(id, idToFollow);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response);
        assertEquals(expected, response.getBody());
        verify(userService, atLeastOnce()).follow(id, idToFollow);
    }

    @Test
    public void unfollowExistingUser() {
        int id = 1, idToUnfollow = 2;
        ApiResponseDto expected = new ApiResponseDto("Unfollow user",
                "User with id " + id + " has unfollowed user with id " + idToUnfollow);
        when(userService.follow(id, idToUnfollow)).thenReturn(expected);

        ResponseEntity<ApiResponseDto> response = userController.follow(id, idToUnfollow);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
        verify(userService, atLeastOnce()).follow(id, idToUnfollow);
    }

    @Test
    public void getFollowersCount() {
        int id = 1;
        FollowersCountDto expected = new FollowersCountDto(id, "John", 2);
        when(userService.getFollowersCount(id)).thenReturn(expected);

        ResponseEntity<FollowersCountDto> response = userController.getFollowersCount(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
        verify(userService, atLeastOnce()).getFollowersCount(id);
    }
}