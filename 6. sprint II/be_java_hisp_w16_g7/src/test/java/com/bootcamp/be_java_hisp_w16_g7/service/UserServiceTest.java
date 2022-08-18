package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import java.util.Comparator;
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


    //Test
    @Test
    public void followUserExists(){
        //arrange
        int id = 1111, idToFollow = 2222;
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        when(userRepository.findUserById(id)).thenReturn(new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        when(userRepository.findUserById(idToFollow)).thenReturn(new User(2222, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), posts));

        //act
        HttpStatus response = userService.follow(id, idToFollow);

        //assert
        assertEquals(response, HttpStatus.OK);
    }

    @Test
    public void followUserNotExists(){
        //arrange
        int id = 1111, idToFollow = 2222;
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        when(userRepository.findUserById(id)).thenReturn(new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        when(userRepository.findUserById(idToFollow)).thenReturn(null);
        //act
        try{
            HttpStatus response = userService.follow(id, idToFollow);
        } catch (Exception e){
            assertEquals(e.getClass(), UserNotFoundException.class);
        }



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
        int id = 1;
        when(userRepository.findUserById(id)).thenReturn(null);

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.getUserFollowedList(id, null));
        // Verify call to repo method
        verify(userRepository, atLeastOnce()).findUserById(id);
    }
}