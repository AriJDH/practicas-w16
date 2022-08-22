package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserIlegalFollow;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FollowerServiceTest {

  @Mock
  IUserRepository userRepository;

  @Mock
  IFollowerRepository followerRepository;

  @InjectMocks
  FollowerService followerService;

  @Test
  void unfollowNonExistentUser() {
    when(userRepository.isValidUser(Mockito.any())).thenReturn(false);
    Assertions.assertThrows(UserNotFoundException.class, () -> followerService.unFollowUser(100, 123));
  }

  @Test
  void unfollowExistentUser() {
    FollowUserDTO followUserDTO = new FollowUserDTO("Unfollow successful");
    when(userRepository.isValidUser(Mockito.any())).thenReturn(true);
    Assertions.assertEquals(followUserDTO, followerService.unFollowUser(100, 123));
  }

  @Test
  public void followUserWithWrongUserId() {

    Integer userId = 205;
    when(userRepository.isValidUser(Mockito.any())).thenReturn(false);

    Assertions.assertThrows(UserNotFoundException.class, () -> followerService.followUser(userId, 100));
  }

  @Test
  public void followUserWithWrongFollowerUserId() {
    Integer userIdToFollow = 405;
    when(userRepository.isValidUser(Mockito.any())).thenReturn(false);

    Assertions.assertThrows(UserNotFoundException.class, () -> followerService.followUser(100, userIdToFollow));
  }

  @Test
  public void followerUserWithRightUsersAlreadyFollowed() {

    when(userRepository.isValidUser(Mockito.any())).thenReturn(true);
    when(followerRepository.verifyFollower(Mockito.any(), Mockito.any())).thenReturn(false);

    Assertions.assertThrows(UserIlegalFollow.class, () -> followerService.followUser(100, 102));
  }

  @Test
  public void followerUserWithRightUsers() {

    FollowUserDTO followUserDTO = new FollowUserDTO("Successful follow-up");

    when(userRepository.isValidUser(Mockito.any())).thenReturn(true);
    when(followerRepository.verifyFollower(Mockito.any(), Mockito.any())).thenReturn(true);

    Assertions.assertEquals(followUserDTO, followerService.followUser(100, 122));
  }
}