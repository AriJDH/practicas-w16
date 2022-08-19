package com.bootcamp.be_java_hisp_w16_g01.controllers;

import com.bootcamp.be_java_hisp_w16_g01.controller.UserController;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}
