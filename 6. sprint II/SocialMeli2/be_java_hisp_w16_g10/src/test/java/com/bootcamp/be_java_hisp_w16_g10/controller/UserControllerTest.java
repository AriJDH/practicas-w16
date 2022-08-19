package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowedListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

   @Mock
   UserService userService;
   @InjectMocks
   UserController userController;

   @Test
   void findAll() {
   }

   @Test
   void US001() {
   }

   @Test
   void US002() {
   }

   @Test
   void shouldReturnListFollowers() {

      // arrange

      Optional<String> opt = Optional.empty();

      FollowersListResDTO followersListResDTO = FollowersListResDTO.builder().userId(1).userName("Ale")
            .followers(List.of()).build();

      // act

      when(userService.listFollowers(1, null)).thenReturn(followersListResDTO);

      ResponseEntity<FollowersListResDTO> resController = userController.US003(1, opt);

      // assert

      verify(userService, atLeastOnce()).listFollowers(followersListResDTO.getUserId(), null);
      Assertions.assertTrue(resController.equals(new ResponseEntity<>(followersListResDTO, HttpStatus.OK)));

   }

   @Test
   void shouldReturnListFollowed() {

      // arrange

      Optional<String> opt = Optional.empty();

      FollowedListResDTO followedListResDTO = FollowedListResDTO.builder().userId(1).userName("Ale").followed(List.of())
            .build();

      // act

      when(userService.listFollowed(1, null)).thenReturn(followedListResDTO);

      ResponseEntity<FollowedListResDTO> resController = userController.US004(1, opt);

      // assert

      verify(userService, atLeastOnce()).listFollowed(followedListResDTO.getUserId(), null);
      Assertions.assertTrue(resController.equals(new ResponseEntity<>(followedListResDTO, HttpStatus.OK)));

   }

   @Test
   <T> void shouldUnfollow() {

      //act

      doNothing().when(userService).unfollow(Mockito.anyInt(), Mockito.anyInt());   

      ResponseEntity<T> resController = userController.US007(Mockito.anyInt(),Mockito.anyInt());   

      // assert
      
      verify(userService,atLeastOnce()).unfollow(Mockito.anyInt(), Mockito.anyInt());
      Assertions.assertTrue(resController.getStatusCodeValue() == 200);

   }
}
