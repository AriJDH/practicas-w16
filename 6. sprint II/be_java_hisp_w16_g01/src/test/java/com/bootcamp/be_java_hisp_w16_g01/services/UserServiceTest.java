package com.bootcamp.be_java_hisp_w16_g01.services;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.service.UserService;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    private static List<User> usersTestList;

    @BeforeEach()
    public void loadData() {
        usersTestList = FactoryUser.getMockedUsers();
    }

    @Test
    void unfollowUserTest() {
        User user1 = usersTestList.get(0);
        User user2 = usersTestList.get(1);

        Integer userId = user2.getUserId();
        Integer userIdToUnfollow = user1.getUserId();
        Boolean result = true;

        UserUnfollowDTO unfollowDTO = new UserUnfollowDTO("Ok", "Usuario dejado de seguir correctamente");

        when(userRepository.getUser(userId)).thenReturn(user2);
        when(userRepository.getUser(userIdToUnfollow)).thenReturn(user1);
        when(userRepository.userIsFollower(user2, user1)).thenReturn(result);
        when(userRepository.userIsFollowed(user1, user2)).thenReturn(result);

        UserUnfollowDTO res  = userService.unfollowUser(userId, userIdToUnfollow);

        Assertions.assertEquals(unfollowDTO.getMessage(), res.getMessage());
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase(), res.getStatus().toUpperCase());
    }

    @Test
    void unfollowUserIdInvalidTest() {
        // userId no existe
        Integer userId = 10;

        User user1 = usersTestList.get(0);
        Integer userIdToUnfollow = user1.getUserId();

        when(userRepository.getUser(userId)).thenReturn(null);
        when(userRepository.getUser(userIdToUnfollow)).thenReturn(user1);

        Assertions.assertThrows(BadRequestException.class, () ->
                userService.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    void unfollowUserIdToUnfollowInvalidTest() {
        User user1 = usersTestList.get(0);
        Integer userId = user1.getUserId();
        Integer userIdToUnfollow = 15;

        when(userRepository.getUser(userId)).thenReturn(user1);
        when(userRepository.getUser(userIdToUnfollow)).thenReturn(null);

        Assertions.assertThrows(BadRequestException.class, () ->
                userService.unfollowUser(userId, userIdToUnfollow));
    }

    @Test
    void userIdToUnfollowIsNotFollowedTest() {
        User user1 = usersTestList.get(0);
        User user3 = usersTestList.get(2);
        Boolean responseUserIsFollowed = false;

        Integer userId = user1.getUserId();
        Integer userIdToUnfollow = user3.getUserId();

        when(userRepository.getUser(userId)).thenReturn(user1);
        when(userRepository.getUser(userIdToUnfollow)).thenReturn(user3);
        when(userRepository.userIsFollowed(user3, user1)).thenReturn(responseUserIsFollowed);

        Assertions.assertThrows(BadRequestException.class, () ->
                userService.unfollowUser(userId, userIdToUnfollow));

        verify(userRepository, atLeast(1)).getUser(userId);
    }

    @Test
    void userIdToUnfollowIsNotFollowedReverseTest() {
        User user1 = usersTestList.get(0);
        User user3 = usersTestList.get(2);
        Boolean responseUserIsFollower = false;
        Boolean responseUserIsFollowed = true;

        Integer userId = user1.getUserId();
        Integer userIdToUnfollow = user3.getUserId();

        when(userRepository.getUser(userId)).thenReturn(user1);
        when(userRepository.getUser(userIdToUnfollow)).thenReturn(user3);
        when(userRepository.userIsFollowed(user3, user1)).thenReturn(responseUserIsFollowed);
        when(userRepository.userIsFollower(user1, user3)).thenReturn(responseUserIsFollower);

        Assertions.assertThrows(BadRequestException.class, () ->
                userService.unfollowUser(userId, userIdToUnfollow));

        verify(userRepository, atLeast(1)).getUser(userId);
    }
}
