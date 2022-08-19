package com.bootcamp.be_java_hisp_w16_g01.services;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void addFollowerUserExists() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        MessageDto expected = new MessageDto("Usuario seguido correctamente");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);
        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(true);
        when(userRepository.userIsSeller(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.getUser(user.getUserId()))
                .thenReturn(user);

        when(userRepository.getUser(userToFollow.getUserId()))
                .thenReturn(userToFollow);


        // Act
        MessageDto result = userService.addFollower(user.getUserId(), userToFollow.getUserId());

        // Assert
        verify(userRepository, atLeast(1)).userExists(user.getUserId());
        verify(userRepository, atLeast(1)).userExists(userToFollow.getUserId());
        verify(userRepository, atLeast(1)).userIsSeller(userToFollow.getUserId());
        verify(userRepository, atLeast(1)).getUser(user.getUserId());
        verify(userRepository, atLeast(1)).getUser(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).addFollower(user.getUserId(), userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).addFollowed(user.getUserId(), userToFollow.getUserId());

        Assertions.assertEquals(expected, result);
    }

    @Test
    void addFollowerUserDoesNotExist() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
    }


    @Test
    void addFollowerUserToFollowDoesNotExist() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);

        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
        verify(userRepository, atLeastOnce()).userExists(userToFollow.getUserId());
    }

    @Test
    void addFollowerUserToFollowIsNotASeller() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);

        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.userIsSeller(userToFollow.getUserId()))
                .thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
        verify(userRepository, atLeastOnce()).userExists(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).userIsSeller(userToFollow.getUserId());
    }
    @Test
    void addFollowerUserAlreadyFollowsUserToFollow() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");
        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);

        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.userIsSeller(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.getUser(user.getUserId()))
                .thenReturn(user);

        when(userRepository.getUser(userToFollow.getUserId()))
                .thenReturn(userToFollow);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
        verify(userRepository, atLeastOnce()).userExists(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).userIsSeller(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        verify(userRepository, atLeastOnce()).getUser(userToFollow.getUserId());
    }
}
