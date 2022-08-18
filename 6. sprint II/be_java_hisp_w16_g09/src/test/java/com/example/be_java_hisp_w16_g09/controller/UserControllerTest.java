package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.service.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    IUserService userService;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("Verificar que si el usuario a seguir no existe hay excepcion")
    void US001WithException() {
        int followerId = 1;
        int toFollowId = 2;

        Mockito.doThrow(new UserNotFoundException(toFollowId)).when(userService).followUser(followerId, toFollowId);

        Assertions.assertThrows(UserNotFoundException.class, () -> userController.US001(followerId, toFollowId));
        Mockito.verify(userService, Mockito.times(1)).followUser(followerId, toFollowId);
    }

    @Test
    @DisplayName("Verificar que si el usuario a seguir existe la respuesta es ok")
    void US001WithoutException() {
        int followerId = 1;
        int toFollowId = 2;

        var response = userController.US001(followerId, toFollowId);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("User "+toFollowId+" followed successfully", response.getBody().getMessage());
        Mockito.verify(userService, Mockito.times(1)).followUser(followerId, toFollowId);
    }

    @Test
    void US002() {
        FollowersCountDTO res = new FollowersCountDTO(2,"Marcos",2);
        when(userService.followerCount(2)).thenReturn(res);
        Assertions.assertTrue(2==userController.US002(2).getBody().getFollowers_count());
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