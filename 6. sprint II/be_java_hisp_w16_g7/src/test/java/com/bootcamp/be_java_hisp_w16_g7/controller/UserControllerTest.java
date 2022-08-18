package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
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
    public void getUserFollowedListExistentUser() {
        ResponseUserDTO u1 = new ResponseUserDTO(2, "Andrés");
        ResponseUserDTO u2 = new ResponseUserDTO(3, "Someone");
        ResponseUserDTO u3 = new ResponseUserDTO(3, "Zzz");
        ResponseUserFollowedDTO user = new ResponseUserFollowedDTO(1, "A user", List.of(u1, u2, u3));
        when(userService.getUserFollowedList(user.getUserId(), null)).thenReturn(user);

        ResponseEntity<ResponseUserFollowedDTO> response = userController.getUserFollowedList(user.getUserId(), null);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, atLeastOnce()).getUserFollowedList(user.getUserId(), null);
    }
}