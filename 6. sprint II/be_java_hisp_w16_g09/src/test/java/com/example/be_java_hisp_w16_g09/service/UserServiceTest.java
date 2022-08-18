package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.exception.OrderNotExist;
import com.example.be_java_hisp_w16_g09.exception.UserHasNoFollowersException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.exception.*;
import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09.util.MapperUtil;
import com.example.be_java_hisp_w16_g09.utility.DTOMapperUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.be_java_hisp_w16_g09.util.UsersUtility.getUserWith5Followers;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;

@SpringBootTest
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
    @DisplayName("Verificar que si el usuario a seguir existe se agrega en la lista")
    void followUser() {
        int followerId = 1;
        int toFollowId = 2;
        User userFollower = new User(followerId, "Javier", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(toFollowId, "Ricardito", new ArrayList<>(), new ArrayList<>());

        Mockito.when(userRepository.searchById(followerId)).thenReturn(userFollower);
        Mockito.when(userRepository.searchById(toFollowId)).thenReturn(userToFollow);
        Mockito.when(postRepository.searchById(toFollowId)).thenReturn(Arrays.asList(new Post()));

        userService.followUser(followerId, toFollowId);


        Assertions.assertTrue(userFollower.isFollowing(userToFollow));
    }

    @Test
    @DisplayName("Verificar que si el usuario a seguir no existe se da una exepcion")
    void followUserException() {
        int followerId = 1;
        int toFollowId = 2;
        User userFollower = new User(followerId, "Javier", new ArrayList<>(), new ArrayList<>());

        Mockito.when(userRepository.searchById(followerId)).thenReturn(userFollower);
        Mockito.when(userRepository.searchById(toFollowId)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userService.followUser(followerId, toFollowId));
    }

    @Test
    @DisplayName("Verificar que si el usuario a seguir es el mismo que el seguidor se da exception")
    void followUserHimselfException() {
        int followerId = 1;

        assertThrows(UserNotAllowedToFollowException.class, () -> userService.followUser(followerId, followerId));
    }

    @Test
    @DisplayName("Verificar que si el usuario a seguir no es vendedor se da exeption")
    void followUserNotSeller() {
        int followerId = 1;
        int toFollowId = 2;
        User userFollower = new User(followerId, "Javier", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(toFollowId, "Ricardito", new ArrayList<>(), new ArrayList<>());

        Mockito.when(userRepository.searchById(followerId)).thenReturn(userFollower);
        Mockito.when(userRepository.searchById(toFollowId)).thenReturn(userToFollow);
        Mockito.when(postRepository.searchById(toFollowId)).thenReturn(null);

        assertThrows(UserToFollowIsNotSellerException.class, () -> userService.followUser(followerId, toFollowId));


    }

    @Test
    @DisplayName("Verificar que si el ya esta seguido se da una exepcion")
    void alreadyFollowedUserException() {
        int followerId = 1;
        int toFollowId = 2;
        User userFollower = new User(followerId, "Javier", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(toFollowId, "Ricardito", new ArrayList<>(), new ArrayList<>());

        Mockito.when(userRepository.searchById(followerId)).thenReturn(userFollower);
        Mockito.when(userRepository.searchById(toFollowId)).thenReturn(userToFollow);

        userFollower.addFollowed(userToFollow);
        userToFollow.addFollower(userFollower);

        assertThrows(UserAlreadyFollowedException.class, () -> userService.followUser(followerId, toFollowId));
    }


    @Test
    void getUsersFollowedBySellers() {
    }

    @Test
    void followerCount() {
        User userMock1 = new User(3, "Mateo", null, null);
        User userMock2 = new User(4, "Agustin", null, null);
        User userMock = new User(2, "Marcos", List.of(userMock1, userMock2), null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        Assertions.assertTrue(2==userService.followerCount(2).getFollowers_count());
    }

    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir existe")
    public void unfollow() {
        //Arrange
         
        User userFollower = new User(1,"Jaimito",new ArrayList<>(),new ArrayList<>());
        User userToUnfolow = new User(2,"Horacio",new ArrayList<>(),new ArrayList<>());
        userToUnfolow.addFollower(userFollower);
        userFollower.addFollowed(userToUnfolow);

        Mockito.when(userRepository.searchById(userFollower.getUserId())).thenReturn(userFollower);
        Mockito.when(userRepository.searchById(userToUnfolow.getUserId())).thenReturn(userToUnfolow);

        //Act
        userService.unfollow(userFollower.getUserId(), userToUnfolow.getUserId());

        //Assert
        Assertions.assertFalse(userFollower.isFollowing(userToUnfolow));

    }

    @Test
    @DisplayName("Verificar que el usuario no puede dejar de seguir a un usuario que no sigue")
    public void unfollow2() {
        //Arrange

        User userFollower = new User(1,"Jaimito",new ArrayList<>(),new ArrayList<>());
        User userToUnfolow = new User(2,"Horacio",new ArrayList<>(),new ArrayList<>());

        Mockito.when(userRepository.searchById(userFollower.getUserId())).thenReturn(userFollower);
        Mockito.when(userRepository.searchById(userToUnfolow.getUserId())).thenReturn(userToUnfolow);

        //Assert
        var exception = assertThrows(UserNotFollowing.class, () -> userService.unfollow(userFollower.getUserId(), userToUnfolow.getUserId()));
        assertEquals(exception.getMessage(), (String.format("User with id: %d not follow user with id: %d",userFollower.getUserId(),userToUnfolow.getUserId())));
    }

    @Test
    @DisplayName("Si el usuario a dejar de seguir no existe lanza una excepcion")
    public void unfollowNotExist() {
        //Arrange
        User userFollower = new User(1,"Jaimito",new ArrayList<>(),new ArrayList<>());

        Mockito.when(userRepository.searchById(77)).thenReturn(null);
        //Act

        //Assert
        assertThrows(UserNotFoundException.class, () -> userService.unfollow(1,77));

    }


    @Test
    void orderByNameAscTest() {
        User userMock1 = new User(3, "Mateo", null, null);
        User userMock2 = new User(4, "Agustin", null, null);
        User userMock = new User(2, "Marcos", List.of(userMock1, userMock2), null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        List<SimpleUserDto> list = new ArrayList<>();
        list = Arrays.asList(new SimpleUserDto(3, "Mateo"), new SimpleUserDto(4, "Agustin"));
        when(dtoMapperUtil.mapList(userMock.getFollowers(), SimpleUserDto.class)).thenReturn(list);
        FollowersDtoResponse user = userService.getAllFollowers(2, "name_asc");
        String userName1 = user.getFollowers().get(0).getUserName();
        String userName2 = user.getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2) < 0);
    }

    @Test
    void orderByNameDescTest() {
        User userMock1 = new User(3, "Agustin", null, null);
        User userMock2 = new User(4, "Mateo", null, null);
        User userMock = new User(2, "Marcos", List.of(userMock1, userMock2), null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        List<SimpleUserDto> list = new ArrayList<>();
        list = Arrays.asList(new SimpleUserDto(3, "Agustin"), new SimpleUserDto(4, "Mateo"));
        when(dtoMapperUtil.mapList(userMock.getFollowers(), SimpleUserDto.class)).thenReturn(list);
        FollowersDtoResponse user = userService.getAllFollowers(2, "name_desc");
        String userName1 = user.getFollowers().get(0).getUserName();
        String userName2 = user.getFollowers().get(1).getUserName();
        Assertions.assertTrue(userName1.compareTo(userName2) > 0);
    }

    @Test
    void orderByNameNotExistTest() {
        User userMock1 = new User(3, "Agustin", null, null);
        User userMock2 = new User(4, "Mateo", null, null);
        User userMock = new User(2, "Marcos", List.of(userMock1, userMock2), null);
        when(userRepository.searchById(2)).thenReturn(userMock);
        List<SimpleUserDto> list = new ArrayList<>();
        list = List.of(new SimpleUserDto(3, "Agustin"), new SimpleUserDto(4, "Mateo"));
        when(dtoMapperUtil.mapList(userMock.getFollowers(), SimpleUserDto.class)).thenReturn(list);
        Assertions.assertThrows(OrderNotExist.class, () -> userService.getAllFollowers(2, "fdgdfg"));
    }

    @Test
    void orderByUserNotExistTest() {
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.getAllFollowers(2435, "name_desc"));
    }

    @Test
    void orderByUserHasNoFollowersTest() {
        User userMock = new User(2, "Marcos", new ArrayList<>(), new ArrayList<>());
        when(userRepository.searchById(2)).thenReturn(userMock);
        Assertions.assertThrows(UserHasNoFollowersException.class, () -> userService.getAllFollowers(2, "name_desc"));
    }


    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente y descendente por nombre ASCENDENTE. (US-0008)")
    void T0004asc() {
        MapperUtil mapperUtil = new MapperUtil();
        User mockUser = getUserWith5Followers();

        List<SimpleUserDto> mockOrderFollowers = mapperUtil.mapList(mockUser.getFollowers(), SimpleUserDto.class).stream()
                .sorted(Comparator.comparing(SimpleUserDto::getUserName))
                .collect(Collectors.toList());
        FollowersDtoResponse mockFollowersDtoResponse = new FollowersDtoResponse(mockUser.getUserId(), mockUser.getUserName(), mockOrderFollowers);

        when(userRepository.searchById(mockUser.getUserId())).thenReturn(mockUser);
        when(dtoMapperUtil.mapList(mockUser.getFollowers(), SimpleUserDto.class)).thenReturn(mapperUtil.mapList(mockUser.getFollowers(), SimpleUserDto.class));

        FollowersDtoResponse response = userService.getAllFollowers(1, "name_asc");

        Assertions.assertEquals(mockFollowersDtoResponse.getFollowers(), response.getFollowers());
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente y descendente por nombre DESCENDENTE. (US-0008)")
    void T0004desc() {
        MapperUtil mapperUtil = new MapperUtil();
        User mockUser = getUserWith5Followers();

        List<SimpleUserDto> mockOrderFollowers = mapperUtil.mapList(mockUser.getFollowers(), SimpleUserDto.class).stream()
                .sorted(Comparator.comparing(SimpleUserDto::getUserName))
                .collect(Collectors.toList());
        mockOrderFollowers.sort(Comparator.comparing(SimpleUserDto::getUserName).reversed());
        FollowersDtoResponse mockFollowersDtoResponse = new FollowersDtoResponse(mockUser.getUserId(), mockUser.getUserName(), mockOrderFollowers);

        when(userRepository.searchById(mockUser.getUserId())).thenReturn(mockUser);
        when(dtoMapperUtil.mapList(mockUser.getFollowers(), SimpleUserDto.class)).thenReturn(mapperUtil.mapList(mockUser.getFollowers(), SimpleUserDto.class));

        FollowersDtoResponse response = userService.getAllFollowers(1, "name_desc");

        Assertions.assertEquals(mockFollowersDtoResponse.getFollowers(), response.getFollowers());
    }

    @Test
    void orderByNameFollowed() {
    }

    @Test
    void getAllFollowers() {
    }
}