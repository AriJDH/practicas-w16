package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.UserResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.PostService;
import com.bootcamp.be_java_hisp_w16_g10.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.bootcamp.be_java_hisp_w16_g10.util.Factory.generateProductReqDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;
    @Mock
    PostController postController;
    @InjectMocks
    UserController userController;

    @Test
    void shouldReturnAllUsers() {
        //act
        when(userService.findAll()).thenReturn(List.of(new UserResDTO()));
        var response = userController.findAll();

        //assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void shouldFollowUser() {
        //arrange

        //act
        doNothing().when(userService).follow(2,1);
        var response = userController.US001(2,1);

        //assert
        verify(userService, atLeastOnce()).follow(2,1);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }


    @Test
    void shouldReturnFollowersCountResDTO() {
        var dato = generateProductReqDTO();
        //arrange
        postController.US005(dato);
        userController.US001(2,1);
        userController.US001(3,1);

        //act
        var response = userController.US002(1);

        when(userService.countFollowers(1)).thenReturn(new FollowersCountResDTO(1,"user1",2));
        var res = userService.countFollowers(1);

        //assert
        assertNotNull(res);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, res.getFollowersCount());
    }

    @Test
    void US003() {
    }

    @Test
    void US004() {
    }

    @Test
    void US007() {
    }
}