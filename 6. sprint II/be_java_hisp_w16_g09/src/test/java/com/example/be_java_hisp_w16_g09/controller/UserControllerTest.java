package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.service.IPostService;
import com.example.be_java_hisp_w16_g09.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    IUserService userService;

    @InjectMocks
    UserController userController;

    @Test
    void US001() {
    }

    @Test
    void US002() {
    }

    @Test
    void US003DescTest() {
        List<SimpleUserDto> list = List.of(new SimpleUserDto(3,"Mateo"),new SimpleUserDto(4,"Agustin"));
        FollowersDtoResponse userMockResponse = new FollowersDtoResponse(2,"Marcos",list);
        when(userService.orderByName(2,"name_desc")).thenReturn(userMockResponse);
        ResponseEntity<FollowersDtoResponse> user = userController.US003(2,"name_desc");
        String userName1 = user.getBody().getFollowers().get(0).getUserName();
        String userName2= user.getBody().getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2)>0);
    }
    @Test
    void US003AscTest() {
        List<SimpleUserDto> list = List.of(new SimpleUserDto(4,"Agustin"),new SimpleUserDto(3,"Mateo"));
        FollowersDtoResponse userMockResponse = new FollowersDtoResponse(2,"Marcos",list);
        when(userService.orderByName(2,"name_asc")).thenReturn(userMockResponse);
        ResponseEntity<FollowersDtoResponse> user = userController.US003(2,"name_asc");
        String userName1 = user.getBody().getFollowers().get(0).getUserName();
        String userName2= user.getBody().getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2)<0);
    }
    @Test
    void US003Test() {
        List<SimpleUserDto> list = List.of(new SimpleUserDto(4,"Agustin"),new SimpleUserDto(3,"Mateo"));
        FollowersDtoResponse userMockResponse = new FollowersDtoResponse(2,"Marcos",list);
        when(userService.getAllFollowers(2)).thenReturn(userMockResponse);
        ResponseEntity<FollowersDtoResponse> user = userController.US003(2,null);
        String userName1 = user.getBody().getFollowers().get(0).getUserName();
        String userName2= user.getBody().getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2)<0);
    }

    @Test
    void US004() {
    }

    @Test
    void US007() {
    }
}