package com.bootcamp.be_java_hisp_w16_g7.service;


import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.*;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.lang.reflect.Type;
import java.util.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    private User expected;
    private List<FollowersDTO> asc, desc;

    @BeforeEach
    public void setUp(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        expected = new User(9999, "Pepito", Arrays.asList(follower1, follower2), new ArrayList<>(), Arrays.asList(new Post()));

        //DTOs
        FollowersDTO juan = new FollowersDTO(follower1.getId(), follower1.getName());
        FollowersDTO pedro = new FollowersDTO(follower2.getId(), follower2.getName());

        //Sorted list
        asc = new ArrayList<>();
        asc.add(juan);
        asc.add(pedro);

        desc = new ArrayList<>();
        desc.add(pedro);
        desc.add(juan);
    }


    //Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista (asc)")
    @Test
    public void getUserFollowersListSortedAsc(){
        //Arrange
        int id = 9999;
        String order = "name_asc";

        when(userRepository.findUserById(id)).thenReturn(expected);

        //Act
        FollowersSellersDTO result = userService.getSellersFollowers(id, order);

        //Assert
        System.out.println("Expected: " + asc);
        System.out.println("Result: " + result.getFollowers());
        Assertions.assertEquals(asc, result.getFollowers());
    }

    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista (desc)")
    @Test
    public void getUserFollowersListSortedDesc(){
        //Arrange
        int id = 9999;
        String order = "name_desc";

        when(userRepository.findUserById(id)).thenReturn(expected);

        //Act
        FollowersSellersDTO result = userService.getSellersFollowers(id, order);

        //Assert
        System.out.println("Expected: " + desc);
        System.out.println("Result: " + result.getFollowers());
        Assertions.assertEquals(desc, result.getFollowers());
    }

    @Test
    public void followUser(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), List.of(new Post()));
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(target);

        //act
        ApiResponseDto response = userService.follow(user.getId(), target.getId());

        //assert
        assertEquals(response.getTitle(), "Follow user");
    }

    @Test
    public void followUserNotExist(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), List.of(new Post()));
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(null);

        //assert
        assertThrows(UserNotFoundException.class, () -> userService.follow(user.getId(), target.getId()));
    }

    @Test
    public void followUserNotSeller(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), List.of());
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(target);

        //assert
        assertThrows(UserIsNotSellerException.class, ()->userService.follow(user.getId(), target.getId()));
    }

    @Test
    public void followUserAlreadyFollowing(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", List.of(user), new ArrayList<>(), List.of(new Post()));
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(target);

        //assert
        assertThrows(AlreadyFollowingException.class, ()->userService.follow(user.getId(), target.getId()));
    }

    @Test
    public void followSameUser(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        //assert
        assertThrows(SameUserException.class, ()->userService.follow(user.getId(), user.getId()));
    }

    @Test
    public void unfollowUser(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", List.of(user), new ArrayList<>(), List.of(new Post()));
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(target);

        //act
        ApiResponseDto response = userService.unfollow(user.getId(), target.getId());

        //assert
        assertEquals(response.getTitle(), "Unfollow user");
    }

    @Test
    public void unfollowUserNotExist(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", List.of(user), new ArrayList<>(), List.of(new Post()));
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(null);

        //assert
        assertThrows(UserNotFoundException.class, ()->userService.unfollow(user.getId(), target.getId()));
    }

    @Test
    public void unfollowUserSameUser(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        //assert
        assertThrows(SameUserException.class, ()->userService.unfollow(user.getId(), user.getId()));
    }

    @Test
    public void unfollowUserNotFollowing(){
        //arrange
        User user = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User target = new User(2222, "Alexander The Great", List.of(), new ArrayList<>(), List.of(new Post()));
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        when(userRepository.findUserById(target.getId())).thenReturn(target);

        //assert
        assertThrows(NotFollowingException.class, ()->userService.unfollow(user.getId(), target.getId()));
    }

    @Test
    public void getUserFollowedListDefaultNameOrder() {
        // Arrange
        User user1 = new User(2, "Someone", List.of(), List.of(), List.of());
        User user2 = new User(3, "Andrés", List.of(), List.of(), List.of());
        User user3 = new User(4, "Zzz", List.of(), List.of(), List.of());
        User user = new User(1, "A user", List.of(), List.of(user1, user2, user3), List.of());
        when(userRepository.findUserById(user.getId())).thenReturn(user);

        // Act
        ResponseUserFollowedDTO response = userService.getUserFollowedList(user.getId(), null);

        // Assert
        assertEquals(user.getId(), response.getUserId());
        assertEquals(user.getName(), response.getUserName());
        assertEquals(user.getFollows().size(), response.getFollowed().size());

        Comparator<ResponseUserDTO> nameComparator = Comparator.comparing(ResponseUserDTO::getUserName);
        // Check if response is in correct order
        assertIterableEquals(response.getFollowed().stream()
                        .sorted(nameComparator)
                        .collect(Collectors.toList()),
                response.getFollowed());
        System.out.println(response.getFollowed());
        // Verify call to repo method
        verify(userRepository, atLeastOnce()).findUserById(user.getId());
    }

    @Test
    public void getUserFollowedListAscendingNameOrder() {
        // Arrange
        User user1 = new User(2, "Someone", List.of(), List.of(), List.of());
        User user2 = new User(3, "Andrés", List.of(), List.of(), List.of());
        User user3 = new User(4, "Zzz", List.of(), List.of(), List.of());
        User user = new User(1, "A user", List.of(), List.of(user1, user2, user3), List.of());
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        String order = "name_asc";

        //Act
        ResponseUserFollowedDTO response = userService.getUserFollowedList(user.getId(), order);

        // Assert
        assertEquals(user.getId(), response.getUserId());
        assertEquals(user.getName(), response.getUserName());
        assertEquals(user.getFollows().size(), response.getFollowed().size());

        Comparator<ResponseUserDTO> nameComparator = Comparator.comparing(ResponseUserDTO::getUserName);
        // Check if response is in correct order
        assertIterableEquals(response.getFollowed().stream()
                        .sorted(nameComparator)
                        .collect(Collectors.toList()),
                response.getFollowed());
        System.out.println(response.getFollowed());
        // Verify call to repo method
        verify(userRepository, atLeastOnce()).findUserById(user.getId());
    }

    @Test
    public void getUserFollowedListDescendingNameOrder() {
        // Arrange
        User user1 = new User(2, "Someone", List.of(), List.of(), List.of());
        User user2 = new User(3, "Andrés", List.of(), List.of(), List.of());
        User user3 = new User(4, "Zzz", List.of(), List.of(), List.of());
        User user = new User(1, "A user", List.of(), List.of(user1, user2, user3), List.of());
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        String order = "name_desc";

        // Act
        ResponseUserFollowedDTO response = userService.getUserFollowedList(user.getId(), order);

        // Assert
        assertEquals(user.getId(), response.getUserId());
        assertEquals(user.getName(), response.getUserName());
        assertEquals(user.getFollows().size(), response.getFollowed().size());

        Comparator<ResponseUserDTO> nameComparator = Comparator.comparing(ResponseUserDTO::getUserName).reversed();
        // Check if response is in correct order
        assertIterableEquals(response.getFollowed().stream()
                        .sorted(nameComparator)
                        .collect(Collectors.toList()),
                response.getFollowed());
        System.out.println(response.getFollowed());
        // Verify call to repo method
        verify(userRepository, atLeastOnce()).findUserById(user.getId());
    }

    @Test
    public void getUserFollowedListInvalidNameOrder() {
        // Arrange
        User user1 = new User(2, "Someone", List.of(), List.of(), List.of());
        User user2 = new User(3, "Andrés", List.of(), List.of(), List.of());
        User user3 = new User(4, "Zzz", List.of(), List.of(), List.of());
        User user = new User(1, "A user", List.of(), List.of(user1, user2, user3), List.of());
        when(userRepository.findUserById(user.getId())).thenReturn(user);
        String order = "invalid";

        // Act & Assert
        assertThrows(InvalidQueryException.class, () -> userService.getUserFollowedList(user.getId(), order));
        // Verify call to repo method
        verify(userRepository, atLeastOnce()).findUserById(user.getId());
    }

    @Test
    public void getUserFollowedListNonexistentUser() {
        // Arrange
        int id = 5;
        when(userRepository.findUserById(id)).thenReturn(null);

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.getUserFollowedList(id, null));
        // Verify call to repo method
        verify(userRepository, atLeastOnce()).findUserById(id);
    }

    @Test
    public void getCountFollowersByIdUser(){
        //arrange
        List<Post> post1 = new ArrayList<>();
        post1.add(new Post());
        User user1 = new User(1111, "Seguidor uno", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2222, "Seguidor Dos", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        List<User> followersList = new ArrayList<>();
        followersList.add(user1);
        followersList.add(user2);
        User user = new User(3333, "Vendedor", followersList, new ArrayList<>(), post1);

        //Mock
        when(userRepository.findUserById(user.getId())).thenReturn(user);

        //act
        FollowersCountDto countFollowers = userService.getFollowersCount(user.getId());

        //assert
        assertEquals(followersList.size(), countFollowers.getCountFollowers());
        verify(userRepository, atLeastOnce()).findUserById(user.getId());
    }
}