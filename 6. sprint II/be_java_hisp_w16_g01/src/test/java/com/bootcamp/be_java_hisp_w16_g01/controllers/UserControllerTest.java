package com.bootcamp.be_java_hisp_w16_g01.controllers;

import com.bootcamp.be_java_hisp_w16_g01.controller.UserController;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    IUserService userService;

    @InjectMocks
    UserController userController;

    @Test

    void unfollowUserTest() {

        Integer userId = 1;
        Integer userIdToUnfollow = 2;
        UserUnfollowDTO unfollowDTO = new UserUnfollowDTO("Ok", "Usuario dejado de seguir correctamente");

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenReturn(unfollowDTO);

        ResponseEntity<UserUnfollowDTO> responseEntity = userController.unfollowUser(userId, userIdToUnfollow);

        Assertions.assertEquals(unfollowDTO, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void unfollowUserBadRequestExceptionTest() {

        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenThrow(new BadRequestException("Usuario no existe id"));

        Assertions.assertThrows(BadRequestException.class, () ->
                userController.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    void unfollowUserNullPointerExceptionTest() {

        Integer userId = null;
        Integer userIdToUnfollow = 2;

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenThrow(new NullPointerException());

        Assertions.assertThrows(NullPointerException.class, () ->
                userController.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    public void nameAscOrderFollowersOk(){
        List<UserDTO> followers = new ArrayList<>();
        followers.add(new UserDTO(3, "alberto"));
        followers.add(new UserDTO(1, "juan"));
        followers.add(new UserDTO(2, "sofia"));

        UserFollowerDTO user = new UserFollowerDTO(4, "user 4", followers);
        when(userService.getFollowers(user.getUserId(), "name_asc")).thenReturn(user);

        userController.getFollowers(user.getUserId(), "name_asc");

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, "name_asc");
    }

    @Test
    public void nameDescOrderFollowersOk(){
        //arrange
        List<UserDTO> followers = new ArrayList<>();
        followers.add(new UserDTO(2, "sofia"));
        followers.add(new UserDTO(1, "juan"));
        followers.add(new UserDTO(3, "alberto"));
        UserFollowerDTO user = new UserFollowerDTO(4, "user 4", followers);
        when(userService.getFollowers(user.getUserId(), "name_desc")).thenReturn(user);

        //act
       userController.getFollowers(user.getUserId(), "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(user.getUserId(), "name_desc");
    }

    @Test
    public void invalidOrderFollowers(){
        Integer userId = 4;
        //arrange
        when(userService.getFollowers(userId, "id_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowers(userId, "id_asc"));
        verify(userService, atLeastOnce()).getFollowers(userId, "id_asc");
    }

    @Test
    public void nullOrderFollowers(){
        List<UserDTO> followers= new ArrayList<>();
        followers.add(new UserDTO(3, "alberto"));
        followers.add(new UserDTO(2, "sofia"));
        followers.add(new UserDTO(1, "juan"));

        UserFollowerDTO user = new UserFollowerDTO(4, "user 4", followers);
        when(userService.getFollowers(user.getUserId(), null)).thenReturn(user);

        UserFollowerDTO response = userController.getFollowers(user.getUserId(), null).getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, null);
        assertTrue(CollectionUtils.isEqualCollection(user.getFollowers(), response.getFollowers()));
    }

    @Test
    public void invalidUserFollowers(){
        Integer userId = 44;
        //arrange
        when(userService.getFollowers(userId, "name_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowers(userId, "name_asc"));
        verify(userService, atLeastOnce()).getFollowers(userId, "name_asc");
    }

    @Test
    public void negativeIdFollowers(){
       Integer userId = -4;
        //arrange
        when(userService.getFollowers(userId, "name_desc")).thenThrow(ConstraintViolationException.class);

        // act & assert
        assertThrows(ConstraintViolationException.class , () -> userController.getFollowers(userId, "name_desc"));
        verify(userService, atLeastOnce()).getFollowers(userId, "name_desc");
    }

    @Test
    public void nullIdFollowers(){
        //arrange
        when(userService.getFollowers(null, "name_desc")).thenThrow(MethodArgumentTypeMismatchException.class);

        // act & assert
        assertThrows(MethodArgumentTypeMismatchException.class , () -> userController.getFollowers(null, "name_desc"));
        verify(userService, atLeastOnce()).getFollowers(null, "name_desc");
    }

    @Test
    public void verifyNameAscOrderFollowers(){
        List<UserDTO> followers = new ArrayList<>();
        followers.add(new UserDTO(3, "alberto"));
        followers.add(new UserDTO(1, "juan"));
        followers.add(new UserDTO(2, "sofia"));

        UserFollowerDTO user = new UserFollowerDTO(4, "user 4", followers);
        when(userService.getFollowers(4, "name_asc")).thenReturn(user);

        UserFollowerDTO response = userController.getFollowers(4, "name_asc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, "name_asc");
        assertEquals(response, user);
    }

    @Test
    public void verifyNameDescOrderFollowers(){
        //arrange
        List<UserDTO> followers = new ArrayList<>();
        followers.add(new UserDTO(2, "sofia"));
        followers.add(new UserDTO(1, "juan"));
        followers.add(new UserDTO(3, "alberto"));
        UserFollowerDTO user = new UserFollowerDTO(4, "user 4", followers);
        when(userService.getFollowers(4, "name_desc")).thenReturn(user);

        //act
        UserFollowerDTO response = userController.getFollowers(4, "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, "name_desc");
        assertEquals(response, user);
    }

    @Test
    public void nameAscOrderFollowedOk(){
        List<UserDTO> followed= new ArrayList<>();
        followed.add(new UserDTO(3, "alberto"));
        followed.add(new UserDTO(1, "juan"));
        followed.add(new UserDTO(2, "sofia"));

        UserFollowedDTO user = new UserFollowedDTO(4, "user 4", followed);
        when(userService.getFollowed(user.getUserId(), "name_asc")).thenReturn(user);

        userController.getFollowed(user.getUserId(), "name_asc");

        // assert
        verify(userService, atLeastOnce()).getFollowed(4, "name_asc");
    }

    @Test
    public void nameDescOrderFollowedOk(){
        //arrange
        List<UserDTO> followed = new ArrayList<>();
        followed.add(new UserDTO(2, "sofia"));
        followed.add(new UserDTO(1, "juan"));
        followed.add(new UserDTO(3, "alberto"));
        UserFollowedDTO user = new UserFollowedDTO(4, "user 4", followed);
        when(userService.getFollowed(user.getUserId(), "name_desc")).thenReturn(user);

        //act
        userController.getFollowed(user.getUserId(), "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(user.getUserId(), "name_desc");
    }

    @Test
    public void invalidOrderFollowed(){
        Integer userId = 4;
        //arrange
        when(userService.getFollowed(userId, "id_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowed(userId, "id_asc"));
        verify(userService, atLeastOnce()).getFollowed(userId, "id_asc");
    }

    @Test
    public void nullOrderFollowed(){
        List<UserDTO> followed= new ArrayList<>();
        followed.add(new UserDTO(3, "alberto"));
        followed.add(new UserDTO(2, "sofia"));
        followed.add(new UserDTO(1, "juan"));

        UserFollowedDTO user = new UserFollowedDTO(4, "user 4", followed);
        when(userService.getFollowed(user.getUserId(), null)).thenReturn(user);

        UserFollowedDTO response = userController.getFollowed(user.getUserId(), null).getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(4, null);
        assertTrue(CollectionUtils.isEqualCollection(user.getFollowed(), response.getFollowed()));
    }

    @Test
    public void invalidUserFollowed(){
        Integer userId = 44;
        //arrange
        when(userService.getFollowed(userId, "name_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowed(userId, "name_asc"));
        verify(userService, atLeastOnce()).getFollowed(userId, "name_asc");
    }

    @Test
    public void negativeIdFollowed(){
        Integer userId = -4;
        //arrange
        when(userService.getFollowed(userId, "name_desc")).thenThrow(ConstraintViolationException.class);

        // act & assert
        assertThrows(ConstraintViolationException.class , () -> userController.getFollowed(userId, "name_desc"));
        verify(userService, atLeastOnce()).getFollowed(userId, "name_desc");
    }

    @Test
    public void nullIdFollowed(){
        //arrange
        when(userService.getFollowed(null, "name_desc")).thenThrow(MethodArgumentTypeMismatchException.class);

        // act & assert
        assertThrows(MethodArgumentTypeMismatchException.class , () -> userController.getFollowed(null, "name_desc"));
        verify(userService, atLeastOnce()).getFollowed(null, "name_desc");
    }

    @Test
    public void verifyNameAscOrderFollowed(){
        List<UserDTO> followed= new ArrayList<>();
        followed.add(new UserDTO(3, "alberto"));
        followed.add(new UserDTO(1, "juan"));
        followed.add(new UserDTO(2, "sofia"));

        UserFollowedDTO user = new UserFollowedDTO(4, "user 4", followed);
        when(userService.getFollowed(user.getUserId(), "name_asc")).thenReturn(user);

        UserFollowedDTO response = userController.getFollowed(user.getUserId(), "name_asc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(user.getUserId(), "name_asc");
        assertEquals(response, user);
    }

    @Test
    public void verifyNameDescOrderFollowed(){
        //arrange
        List<UserDTO> followed = new ArrayList<>();
        followed.add(new UserDTO(2, "sofia"));
        followed.add(new UserDTO(1, "juan"));
        followed.add(new UserDTO(3, "alberto"));
        UserFollowedDTO user = new UserFollowedDTO(4, "user 4", followed);
        when(userService.getFollowed(user.getUserId(), "name_desc")).thenReturn(user);

        //act
        UserFollowedDTO response = userController.getFollowed(user.getUserId(), "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(user.getUserId(), "name_desc");
        assertEquals(response, user);
    }


    @DisplayName("Cálculo correcto cantidad total de seguidores que posee un usuario")
    void rightCantFollowers() {
        //Arrange
        Integer userId = 1;
        FollowersCountDTO mockFollowersCount = new FollowersCountDTO(userId, "German", 5);
        when(userService.getCantFollowers(userId)).thenReturn(mockFollowersCount);
        //Act
        ResponseEntity<FollowersCountDTO> result = userController.getFollowersCount(userId);
        //Assert
        assertEquals(mockFollowersCount.getFollowersCount(),result.getBody().getFollowersCount());
        verify(userService, atLeastOnce()).getCantFollowers(userId);
    }

}
