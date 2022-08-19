package com.bootcamp.be_java_hisp_w16_g01.controllers;

import com.bootcamp.be_java_hisp_w16_g01.controller.UserController;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.MessageDto;
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
    void addFollower() {
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
        verify(userService, atLeastOnce()).addFollower(userId, userIdToFollow);
    }
}
