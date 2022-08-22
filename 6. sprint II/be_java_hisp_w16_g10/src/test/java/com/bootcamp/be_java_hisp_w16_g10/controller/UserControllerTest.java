package com.bootcamp.be_java_hisp_w16_g10.controller;

import static com.bootcamp.be_java_hisp_w16_g10.util.Factory.generateProductReqDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowedListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.UserResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController;
    @Mock
    PostController postController;

    @Test
    void shouldReturnListFollowers() {

        // arrange

        Optional<String> opt = Optional.empty();

        FollowersListResDTO followersListResDTO = FollowersListResDTO.builder().userId(1).userName("Ale")
                .followers(List.of()).build();

        // act
        when(userService.listFollowers(1, "name_asc")).thenReturn(followersListResDTO);
        ResponseEntity<FollowersListResDTO> resController = userController.US003(1, opt);

        // assert
        verify(userService, atLeastOnce()).listFollowers(followersListResDTO.getUserId(), "name_asc");
        assertEquals(resController, new ResponseEntity<>(followersListResDTO, HttpStatus.OK));
    }

    @Test
    void shouldReturnListFollowed() {
        // arrange
        Optional<String> opt = Optional.empty();
        FollowedListResDTO followedListResDTO = FollowedListResDTO.builder().userId(1).userName("Ale").followed(List.of())
                .build();

        // act
        when(userService.listFollowed(1, "name_asc")).thenReturn(followedListResDTO);
        ResponseEntity<FollowedListResDTO> resController = userController.US004(1, opt);

        // assert
        verify(userService, atLeastOnce()).listFollowed(followedListResDTO.getUserId(), "name_asc");
        assertEquals(resController, new ResponseEntity<>(followedListResDTO, HttpStatus.OK));
    }

    @Test
    <T> void shouldUnfollow() {
        //act
        doNothing().when(userService).unfollow(Mockito.anyInt(), Mockito.anyInt());
        ResponseEntity<T> resController = userController.US007(Mockito.anyInt(), Mockito.anyInt());

        // assert
        verify(userService, atLeastOnce()).unfollow(Mockito.anyInt(), Mockito.anyInt());
        assertEquals(200, resController.getStatusCodeValue());
    }

    @Test
    void shouldReturnAllUsers() {
        //act
        when(userService.findAll()).thenReturn(List.of(new UserResDTO()));
        var response = userController.findAll();

        //assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
    }

    @Test
    void shouldFollowUser() {
        //arrange

        //act
        doNothing().when(userService).follow(2, 1);
        ResponseEntity<UserResDTO> response = userController.US001(2, 1);

        //assert
        verify(userService, atLeastOnce()).follow(2, 1);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
    }


    @Test
    void shouldReturnFollowersCountResDTO() {
        PostReqDTO dato = generateProductReqDTO();
        //arrange
        postController.US005(dato);
        userController.US001(2, 1);
        userController.US001(3, 1);

        //act
        ResponseEntity<FollowersCountResDTO> response = userController.US002(1);

        when(userService.countFollowers(1)).thenReturn(new FollowersCountResDTO(1, "user1", 2));
        FollowersCountResDTO res = userService.countFollowers(1);

        //assert
        assertNotNull(res);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, res.getFollowersCount());
    }

}
