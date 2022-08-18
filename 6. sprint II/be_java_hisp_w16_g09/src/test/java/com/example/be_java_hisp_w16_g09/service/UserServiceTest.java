package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.exception.OrderNotExist;
import com.example.be_java_hisp_w16_g09.exception.UserHasNoFollowersException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09.repository.UserRepository;
import com.example.be_java_hisp_w16_g09.utility.DTOMapperUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @Mock
    IPostRepository postRepository;
    @Mock
    DTOMapperUtil dtoMapperUtil;

    @InjectMocks
    UserService userService;

    @Test
    void followUser() {
    }

    @Test
    void getUsersFollowedBySellers() {
    }

    @Test
    void followerCount() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void orderByNameAscTest() {
        User userMock1= new User(3,"Mateo",null,null);
        User userMock2= new User(4,"Agustin",null,null);
        User userMock = new User(2,"Marcos", List.of(userMock1,userMock2),null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        List<SimpleUserDto> list = new ArrayList<>();
        list = List.of(new SimpleUserDto(3,"Mateo"),new SimpleUserDto(4,"Agustin"));
        when(dtoMapperUtil.mapList(userMock.getFollowers(),SimpleUserDto.class)).thenReturn(list);
        FollowersDtoResponse user = userService.orderByName(2,"name_asc");
        String userName1 = user.getFollowers().get(0).getUserName();
        String userName2= user.getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2)<0);
    }
    @Test
    void orderByNameDescTest() {
        User userMock1= new User(3,"Agustin",null,null);
        User userMock2= new User(4,"Mateo",null,null);
        User userMock = new User(2,"Marcos", List.of(userMock1,userMock2),null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        List<SimpleUserDto> list = new ArrayList<>();
        list = List.of(new SimpleUserDto(3,"Agustin"),new SimpleUserDto(4,"Mateo"));
        when(dtoMapperUtil.mapList(userMock.getFollowers(),SimpleUserDto.class)).thenReturn(list);
        FollowersDtoResponse user = userService.orderByName(2,"name_desc");
        String userName1 = user.getFollowers().get(0).getUserName();
        String userName2= user.getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2)>0);
    }
    @Test
    void orderByNameNotExistTest() {
        User userMock1= new User(3,"Agustin",null,null);
        User userMock2= new User(4,"Mateo",null,null);
        User userMock = new User(2,"Marcos", List.of(userMock1,userMock2),null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        List<SimpleUserDto> list = new ArrayList<>();
        list = List.of(new SimpleUserDto(3,"Agustin"),new SimpleUserDto(4,"Mateo"));
        when(dtoMapperUtil.mapList(userMock.getFollowers(),SimpleUserDto.class)).thenReturn(list);
        Assertions.assertThrows(OrderNotExist.class,() -> userService.orderByName(2,"fdgdfg"));
    }
    @Test
    void orderByUserNotExistTest() {
        Assertions.assertThrows(UserNotFoundException.class,() -> userService.orderByName(2435,"name_desc"));
    }
    @Test
    void orderByUserHasNoFollowersTest() {
        User userMock = new User(2,"Marcos", new ArrayList<>(),new ArrayList<>());
        when(userRepository.searchById(2)).thenReturn(userMock);
        Assertions.assertThrows(UserHasNoFollowersException.class,() -> userService.orderByName(2,"name_desc"));
    }


    @Test
    void orderByNameFollowed() {
    }

    @Test
    void getAllFollowers() {
    }
}