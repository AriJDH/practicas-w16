package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.FollowIdDto;
import com.bootcamp.SocialMeli2.dto.ResponseDTO;
import com.bootcamp.SocialMeli2.entity.Follow;
import com.bootcamp.SocialMeli2.entity.User;
import com.bootcamp.SocialMeli2.exceptions.FollowException;
import com.bootcamp.SocialMeli2.exceptions.UserNotFoundException;
import com.bootcamp.SocialMeli2.repository.UserFollowersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FollowUnFollowServiceTest {

    @Mock
    UserFollowersRepository userFollowersRepository;

    @InjectMocks
    FollowUnFollowService followUnFollowService;


    @Test
    public void followServiceTest_404() {
        //Arrange
        List<User> userList = new ArrayList<>();
        FollowIdDto idDto = new FollowIdDto(7, 7);

        when(userFollowersRepository.getUsersList()).thenReturn(userList);
        //Act

        Assertions.assertThrows(UserNotFoundException.class, () -> followUnFollowService.followUser(idDto));
    }


    @Test
    public void followServiceTest_ALREADY_FOLLOWING() {
        //Arrange

        List<User> listUser = new ArrayList<>();

        List<Follow> listFollower = new ArrayList<>();
        List<Follow> listFollowed = new ArrayList<>();

        Follow follow = new Follow(7, "Juan");
        listFollowed.add(follow);

        User userOne = new User(3, "Tomas", listFollowed, listFollower);

        List<Follow> listFollowerTwo = new ArrayList<>();
        List<Follow> listFollowedTwo = new ArrayList<>();

        Follow followTwo = new Follow(3, "Tomas");
        listFollowerTwo.add(followTwo);

        User userTwo = new User(7, "Juan", listFollowerTwo, listFollowedTwo);

        FollowIdDto followIdDto = new FollowIdDto(3, 7);

        listUser.add(userOne);
        listUser.add(userTwo);

        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(listUser);

        //Act

        //Assert
        Assertions.assertThrows(FollowException.class, () -> followUnFollowService.followUser(followIdDto));
    }


    @Test
    public void followServiceTest_OK() {
        //Arrange
        ResponseDTO responseDTOExpected = new ResponseDTO("Follow Successful", 200);
        List<User> listUser = new ArrayList<>();

        List<Follow> listFollower = new ArrayList<>();
        List<Follow> listFollowed = new ArrayList<>();

        Follow follow = new Follow(3, "Juan");
        listFollowed.add(follow);

        User userOne = new User(3, "Tomas", listFollowed, listFollower);
        User userTwo = new User(7, "Juan", listFollower, listFollowed);

        FollowIdDto followIdDto = new FollowIdDto(3, 7);

        listUser.add(userOne);
        listUser.add(userTwo);

        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(listUser);

        //Act
        ResponseDTO responseDTOService;
        responseDTOService = followUnFollowService.followUser(followIdDto);

        //Assert
        Assertions.assertEquals(responseDTOExpected, responseDTOService);
    }


    @Test
    @DisplayName("El usuario a dejar de seguir NO existe")
    public void unFollowUserNotFoundTest() {

        //Arrange
        List<User> listUser = new ArrayList<>();
        List<Follow> listFollower = new ArrayList<>();
        List<Follow> listFollowed = new ArrayList<>();

        User user = new User(7, "Karen", listFollower, listFollowed);
        listUser.add(user);

        FollowIdDto followIdDto = new FollowIdDto(7, 9);

        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(listUser);

        //Act //Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> followUnFollowService.unFollowUser(followIdDto));

    }


    @Test
    @DisplayName("El usuario a dejar de seguir SI existe")
    public void unFollowUserFoundTest() {

        //Arrange
        ResponseDTO responseDTOExpected = new ResponseDTO("Unfollow Successful", 200);
        List<User> listUser = new ArrayList<>();

        List<Follow> listFollower = new ArrayList<>();
        List<Follow> listFollowed = new ArrayList<>();

        Follow follow = new Follow(7, "Juan");
        listFollowed.add(follow);

        User userOne = new User(3, "Tomas", listFollowed, listFollower);

        List<Follow> listFollowerTwo = new ArrayList<>();
        List<Follow> listFollowedTwo = new ArrayList<>();

        Follow followTwo = new Follow(3, "Tomas");
        listFollowerTwo.add(followTwo);

        User userTwo = new User(7, "Juan", listFollowerTwo, listFollowedTwo);

        FollowIdDto followIdDto = new FollowIdDto(3, 7);

        listUser.add(userOne);
        listUser.add(userTwo);

        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(listUser);

        //Act
        ResponseDTO responseDTOService;
        responseDTOService = followUnFollowService.unFollowUser(followIdDto);

        //Assert
        Assertions.assertEquals(responseDTOExpected, responseDTOService);
    }


}
