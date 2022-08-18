package com.bootcamp.SocialMeli2.unitary.service;

import com.bootcamp.SocialMeli2.dto.response.UserFollowedDto;
import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.exception.UserNotFoundException;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.service.ProductService;
import com.bootcamp.SocialMeli2.service.UserService;
import com.bootcamp.SocialMeli2.unitary.util.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private User user1;
    private User user2;
    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        user1 = TestUtils.getOneUser(1, "Horacio");
        user2 = TestUtils.getOneUser(2, "Pedro");
    }

    @Test
    @DisplayName("T0001 follow user que no existe US0001")
    void addFollowerException() {
        when(userRepository.isPresent(user1.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user1.getUserId())).thenReturn(user1);
        when(userRepository.isPresent(user2.getUserId())).thenReturn(false);
        assertThrows(UserNotFoundException.class, () -> userService.addFollower(user1.getUserId(), user2.getUserId()));
        verify(userRepository, atLeastOnce()).isPresent(anyInt());
        verify(userRepository, atLeastOnce()).getUserById(anyInt());

    }

    @Test
    @DisplayName("T0001 follow user que existe US0001")
    void addFollower() {
        when(userRepository.isPresent(user1.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user1.getUserId())).thenReturn(user1);
        when(userRepository.isPresent(user2.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user2.getUserId())).thenReturn(user2);
        userService.addFollower(user1.getUserId(), user2.getUserId());

        assertTrue(user2.getFollowerList().size() > 0);
        verify(userRepository, atLeastOnce()).isPresent(anyInt());

    }

    @Test
    void getUserFollowerCount() {
    }

    @Test
    @DisplayName("T0002 Quitando seguidores Exception US0007")
    void unfollowUserException() {

        user2.getFollowerList().add(user1);
        user1.getFollowedList().add(user2);

        when(userRepository.isPresent(user1.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user1.getUserId())).thenReturn(user1);
        when(userRepository.isPresent(user2.getUserId())).thenReturn(false);
        assertThrows(UserNotFoundException.class, () -> userService.unfollowUser(user1.getUserId(), user2.getUserId()));
        verify(userRepository, atLeastOnce()).isPresent(anyInt());
        verify(userRepository, atLeastOnce()).getUserById(anyInt());
    }

    @Test
    @DisplayName("T0002 Quitando seguidores OK US0007")
    void unfollowUser() {

        user2.getFollowerList().add(user1);
        user1.getFollowedList().add(user2);

        when(userRepository.isPresent(user1.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user1.getUserId())).thenReturn(user1);
        when(userRepository.isPresent(user2.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user2.getUserId())).thenReturn(user2);
        userService.unfollowUser(user1.getUserId(), user2.getUserId());

        assertEquals(0, user2.getFollowerList().size());
    }

    @Test
    void getUserById() {
    }


    @Test
    @DisplayName("T0003")
    void getVendorsFollowedByUser() {
        user1.setFollowedList(TestUtils.getFourUsersTwoVendors());
        String order= "name_asc";
        when(userRepository.isPresent(user1.getUserId())).thenReturn(true);
        when(userRepository.getUserById(user1.getUserId())).thenReturn(user1);
        UserFollowedDto result= userService.getVendorsFollowedByUser(user1.getUserId(),order);

    }

    @Test
    void isVendor() {
    }

    @Test
    void getAllVendorFollowers() {
    }

    @Test
    void getPostFromFollowed() {
    }

    @Test
    void orderPostList() {
    }
}