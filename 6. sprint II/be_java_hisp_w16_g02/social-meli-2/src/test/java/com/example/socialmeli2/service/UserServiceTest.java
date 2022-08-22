package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.UserFollowedListDto;
import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.dto.UserFollowersListDto;
import com.example.socialmeli2.exception.InputNotValidException;
import com.example.socialmeli2.exception.UserNotFoundException;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IRepository<User> mockRepository;

    @InjectMocks
    UserService service;
    @Test
    @DisplayName("Verificar que el usuario a seguir exista")
    void testCorrectlyAddFollower() {
        // Arrange
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);

        // Act
        service.addFollower(user1.getUserId(),user2.getUserId());
        List<User> followed = user1.getFollowed();

        // Assert
        Assertions.assertEquals(1, followed.size());
    }//T0001
    @Test
    @DisplayName("Verificar que el usuario a seguir no exista")
    void testAddFollowerWithException() {
        // Arrange
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);

        // Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> service.addFollower(user1.getUserId(),user2.getUserId()));
    }//T0001
    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir exista.")
    void testRemoveFollower() {
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);

        service.addFollower(user1.getUserId(),user2.getUserId());

        // Act
        service.removeFollower(user1.getUserId(),user2.getUserId());
        List<User> followedAfterRemoving = user1.getFollowed();

        // Assert
        Assertions.assertTrue(followedAfterRemoving.isEmpty());
    }//T0002
    @Test
    @DisplayName("Verificar que el usuario a dejar de seguir no exista.")
    void testRemoveFollowerWithException() {
        // Arrange
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);

        // Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> service.removeFollower(user1.getUserId(),user2.getUserId()));
    }// T0002
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista -- ASC")
    void testGetFollowersListByUserIdByOrderAsc(){

        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user2.getUserId(),user1.getUserId());
        service.addFollower(user3.getUserId(),user1.getUserId());
        service.addFollower(user4.getUserId(),user1.getUserId());

        // Act
        Optional<String> order = Optional.of("name_asc");
        UserFollowersListDto userResult=service.getFollowersListByUserId(user1.getUserId(), order);

        // Assert
        Assertions.assertEquals("claudio",userResult.getFollowers().get(0).getUserName());
        Assertions.assertEquals("diego",userResult.getFollowers().get(1).getUserName());
        Assertions.assertEquals("eri",userResult.getFollowers().get(2).getUserName());

    }// T0004
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista -- DESC")
    void testGetFollowersListByUserIdByOrderDesc(){

        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user2.getUserId(),user1.getUserId());
        service.addFollower(user3.getUserId(),user1.getUserId());
        service.addFollower(user4.getUserId(),user1.getUserId());

        // Act
        Optional<String> order = Optional.of("name_desc");
        UserFollowersListDto userResult=service.getFollowersListByUserId(user1.getUserId(), order);

        // Assert
        Assertions.assertEquals("eri",userResult.getFollowers().get(0).getUserName());
        Assertions.assertEquals("diego",userResult.getFollowers().get(1).getUserName());
        Assertions.assertEquals("claudio",userResult.getFollowers().get(2).getUserName());

    }// T0004
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista -- ASC")
    void testGetFollowedListByUserIdByOrderAsc(){

        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user1.getUserId(),user2.getUserId());
        service.addFollower(user1.getUserId(),user3.getUserId());
        service.addFollower(user1.getUserId(),user4.getUserId());

        // Act
        Optional<String> order = Optional.of("name_asc");
        UserFollowedListDto userResult=service.getFollowedListByUserId(user1.getUserId(), order);

        // Assert
        Assertions.assertEquals("claudio",userResult.getFollowed().get(0).getUserName());
        Assertions.assertEquals("diego",userResult.getFollowed().get(1).getUserName());
        Assertions.assertEquals("eri",userResult.getFollowed().get(2).getUserName());

    }// T0004
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista -- DESC")
    void testGetFollowedListByUserIdByOrderDesc(){

        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user1.getUserId(),user2.getUserId());
        service.addFollower(user1.getUserId(),user3.getUserId());
        service.addFollower(user1.getUserId(),user4.getUserId());

        // Act
        Optional<String> order = Optional.of("name_desc");
        UserFollowedListDto userResult=service.getFollowedListByUserId(user1.getUserId(), order);

        // Assert
        Assertions.assertEquals("eri",userResult.getFollowed().get(0).getUserName());
        Assertions.assertEquals("diego",userResult.getFollowed().get(1).getUserName());
        Assertions.assertEquals("claudio",userResult.getFollowed().get(2).getUserName());

    }// T0004
    @Test
    @DisplayName("Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    void testGetFollowersCountByUserId() {
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user2.getUserId(),user1.getUserId());
        service.addFollower(user3.getUserId(),user1.getUserId());
        service.addFollower(user4.getUserId(),user1.getUserId());

        // Act
        UserFollowersCountDto userResult=service.getFollowersCountByUserId(user1.getUserId());

        // Assert
        Assertions.assertEquals(3,userResult.getFollowersCount());
    }// T0007
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista - Ordenamiento inválido")
    void testGetFollowedListByUserIdWithInvalidOrder() {
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user1.getUserId(),user2.getUserId());
        service.addFollower(user1.getUserId(),user3.getUserId());
        service.addFollower(user1.getUserId(),user4.getUserId());

        // Act&Assert
        Assertions.assertThrows(InputNotValidException.class, () -> service.getFollowedListByUserId(user1.getUserId(), Optional.of("invalid")));
    } // T0003
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento alfabético exista - Ordenamiento inválido")
    void testGetFollowersListByUserIdWithInvalidOrder() {
        User user1 = Util.getUser(1, "gonza");
        User user2 = Util.getUser(2, "eri");
        User user3 = Util.getUser(3, "claudio");
        User user4 = Util.getUser(4, "diego");

        // Mock
        when(mockRepository.getById(user1.getUserId())).thenReturn(user1);
        when(mockRepository.getById(user2.getUserId())).thenReturn(user2);
        when(mockRepository.getById(user3.getUserId())).thenReturn(user3);
        when(mockRepository.getById(user4.getUserId())).thenReturn(user4);

        service.addFollower(user2.getUserId(),user1.getUserId());
        service.addFollower(user3.getUserId(),user1.getUserId());
        service.addFollower(user4.getUserId(),user1.getUserId());

        // Act&Assert
        Assertions.assertThrows(InputNotValidException.class, () -> service.getFollowersListByUserId(user1.getUserId(), Optional.of("invalid")));
    } // T0003

}