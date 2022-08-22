package com.bootcamp.be_java_hisp_w16_g01.controllers;

import com.bootcamp.be_java_hisp_w16_g01.controller.UserController;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowersCountDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
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
    public void nameAscOrderFollowersTest(){

        UserFollowerDTO user = FactoryUser.getUserFollowerAsc();
        when(userService.getFollowers(user.getUserId(), "name_asc")).thenReturn(user);

        userController.getFollowers(user.getUserId(), "name_asc");

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, "name_asc");
    }

    @Test
    public void nameDescOrderFollowersTest(){
        //arrange
        UserFollowerDTO user = FactoryUser.getUserFollowerDesc();
        when(userService.getFollowers(user.getUserId(), "name_desc")).thenReturn(user);

        //act
       userController.getFollowers(user.getUserId(), "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(user.getUserId(), "name_desc");
    }

    @Test
    public void invalidOrderFollowersTest(){
        Integer userId = 4;
        //arrange
        when(userService.getFollowers(userId, "id_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowers(userId, "id_asc"));
        verify(userService, atLeastOnce()).getFollowers(userId, "id_asc");
    }

    @Test
    public void nullOrderFollowersTest(){

        UserFollowerDTO user = FactoryUser.getUserFollower();
        when(userService.getFollowers(user.getUserId(), null)).thenReturn(user);

        UserFollowerDTO response = userController.getFollowers(user.getUserId(), null).getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, null);
        assertTrue(CollectionUtils.isEqualCollection(user.getFollowers(), response.getFollowers()));
    }

    @Test
    public void invalidUserFollowersTest(){
        Integer userId = 44;
        //arrange
        when(userService.getFollowers(userId, "name_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowers(userId, "name_asc"));
        verify(userService, atLeastOnce()).getFollowers(userId, "name_asc");
    }

    @Test
    public void negativeIdFollowersTest(){
       Integer userId = -4;
        //arrange
        when(userService.getFollowers(userId, "name_desc")).thenThrow(ConstraintViolationException.class);

        // act & assert
        assertThrows(ConstraintViolationException.class , () -> userController.getFollowers(userId, "name_desc"));
        verify(userService, atLeastOnce()).getFollowers(userId,"name_desc");
    }

    @Test
    public void nullIdFollowersTest(){
        //arrange
        when(userService.getFollowers(null, "name_desc")).thenThrow(MethodArgumentTypeMismatchException.class);

        // act & assert
        assertThrows(MethodArgumentTypeMismatchException.class , () -> userController.getFollowers(null, "name_desc"));
        verify(userService, atLeastOnce()).getFollowers(null, "name_desc");
    }

    @Test
    public void verifyNameAscOrderFollowersTest(){

        UserFollowerDTO user = FactoryUser.getUserFollowerAsc();
        when(userService.getFollowers(4, "name_asc")).thenReturn(user);

        UserFollowerDTO response = userController.getFollowers(4, "name_asc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, "name_asc");
        assertEquals(user, response);
    }

    @Test
    public void verifyNameDescOrderFollowersTest(){
        //arrange
        UserFollowerDTO user = FactoryUser.getUserFollowerDesc();
        when(userService.getFollowers(4, "name_desc")).thenReturn(user);

        //act
        UserFollowerDTO response = userController.getFollowers(4, "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowers(4, "name_desc");
        assertEquals(user, response);
    }

    @Test
    public void nameAscOrderFollowedTest(){

        UserFollowedDTO user = FactoryUser.getUserFollowedOrderAsc();
        when(userService.getFollowed(user.getUserId(), "name_asc")).thenReturn(user);

        userController.getFollowed(user.getUserId(), "name_asc");

        // assert
        verify(userService, atLeastOnce()).getFollowed(4, "name_asc");
    }

    @Test
    public void nameDescOrderFollowedTest(){
        //arrange
        UserFollowedDTO user = FactoryUser.getUserFollowedOrderDesc();
        when(userService.getFollowed(user.getUserId(), "name_desc")).thenReturn(user);

        //act
        userController.getFollowed(user.getUserId(), "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(user.getUserId(), "name_desc");
    }

    @Test
    public void invalidOrderFollowedTest(){
        Integer userId = 4;
        //arrange
        when(userService.getFollowed(userId, "id_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowed(userId, "id_asc"));
        verify(userService, atLeastOnce()).getFollowed(userId, "id_asc");
    }

    @Test
    public void nullOrderFollowedTest(){

        UserFollowedDTO user = FactoryUser.getUserFollowed();
        when(userService.getFollowed(user.getUserId(), null)).thenReturn(user);

        UserFollowedDTO response = userController.getFollowed(user.getUserId(), null).getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(4, null);
        assertTrue(CollectionUtils.isEqualCollection(user.getFollowed(), response.getFollowed()));
    }

    @Test
    public void invalidUserFollowedTest(){
        Integer userId = 44;
        //arrange
        when(userService.getFollowed(userId, "name_asc")).thenThrow(BadRequestException.class);

        // act & assert
        assertThrows(BadRequestException.class , () -> userController.getFollowed(userId, "name_asc"));
        verify(userService, atLeastOnce()).getFollowed(userId, "name_asc");
    }

    @Test
    public void negativeIdFollowedTest(){
        Integer userId = -4;
        //arrange
        when(userService.getFollowed(userId, "name_desc")).thenThrow(ConstraintViolationException.class);

        // act & assert
        assertThrows(ConstraintViolationException.class , () -> userController.getFollowed(userId, "name_desc"));
        verify(userService, atLeastOnce()).getFollowed(userId, "name_desc");
    }

    @Test
    public void nullIdFollowedTest(){
        //arrange
        when(userService.getFollowed(null, "name_desc")).thenThrow(MethodArgumentTypeMismatchException.class);

        // act & assert
        assertThrows(MethodArgumentTypeMismatchException.class , () -> userController.getFollowed(null, "name_desc"));
        verify(userService, atLeastOnce()).getFollowed(null, "name_desc");
    }

    @Test
    public void verifyNameAscOrderFollowedTest(){

        UserFollowedDTO user = FactoryUser.getUserFollowedOrderAsc();
        when(userService.getFollowed(user.getUserId(), "name_asc")).thenReturn(user);

        UserFollowedDTO response = userController.getFollowed(user.getUserId(), "name_asc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(user.getUserId(), "name_asc");
        assertEquals(user, response);
    }

    @Test
    public void verifyNameDescOrderFollowedTest(){
        //arrange

        UserFollowedDTO user = FactoryUser.getUserFollowedOrderDesc();
        when(userService.getFollowed(user.getUserId(), "name_desc")).thenReturn(user);

        //act
        UserFollowedDTO response = userController.getFollowed(user.getUserId(), "name_desc").getBody();

        // assert
        verify(userService, atLeastOnce()).getFollowed(user.getUserId(), "name_desc");
        assertEquals(user, response);
    }


    @Test
    @DisplayName("Cálculo correcto cantidad total de seguidores que posee un usuario")
    public void rightCantFollowersTest() {
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


    @Test
    void addFollowerTest() {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;
        MessageDto expectedMessage = new MessageDto("Usuario seguido correctamente");

        ResponseEntity<MessageDto> expectedResponse = new ResponseEntity<> (expectedMessage, HttpStatus.OK);

        when(userService.addFollower(userId, userIdToFollow))
                .thenReturn(expectedMessage);

        // Act
        ResponseEntity<MessageDto> response = this.userController.addFollower(userId, userIdToFollow);

        // Assert
        Assertions.assertEquals(expectedResponse, response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(userService, atLeastOnce()).addFollower(userId, userIdToFollow);
    }

    @Test
    void addFollowerErrorTest() {
        // Arrange
        Integer userId = 1;
        Integer userIdToFollow = 2;

        when(userService.addFollower(userId, userIdToFollow))
                .thenThrow(BadRequestException.class);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userController.addFollower(userId, userIdToFollow));
        verify(userService, atLeastOnce()).addFollower(userId, userIdToFollow);
    }
}
