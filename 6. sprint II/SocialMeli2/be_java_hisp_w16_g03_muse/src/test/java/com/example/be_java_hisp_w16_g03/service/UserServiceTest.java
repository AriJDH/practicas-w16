package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidOrderException;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.be_java_hisp_w16_g03.utils.MocksUser.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService userService;

    @DisplayName("Verifica que el tipo de ordenamiento alfabético de los seguidos exista")//T-0003
    @Test
    public void correctOrderValueFollowedsTest() {

        User user = createUser();
        when(repository.getUserById(user.getUserId())).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.getFollowedUsers(user.getUserId(), NAME_ASC));
        verify(repository, times(1)).getUserById(user.getUserId());
    }

    @DisplayName("Notifica la no existencia del tipo de ordenamiento de los seguidos mediante una excepción")//T-0003
    @Test
    public void incorrectOrderValueFollowedsTest() {
        String incorrectOrder = "WRONG";
        User user = createUser();
        when(repository.getUserById(user.getUserId())).thenReturn(Optional.of(user));

        assertThrows(InvalidOrderException.class, () -> userService.getFollowedUsers(user.getUserId(), incorrectOrder));
        verify(repository, Mockito.times(1)).getUserById(user.getUserId());
    }

    @DisplayName("Verifica que el tipo ordenamiento alfabético de los seguidores exista")//T-0003
    @Test
    public void correctOrderValueFollowersTest() {

        User user = createUser();
        when(repository.getUserById(user.getUserId())).thenReturn(Optional.of(user));

        assertDoesNotThrow(() -> userService.getFollowers(user.getUserId(), NAME_ASC));
        verify(repository, Mockito.times(1)).getUserById(user.getUserId());
    }

    @DisplayName("Notifica la no existencia del tipo de ordenamiento de los seguidores mediante una excepción")//T-0003
    @Test
    public void incorrectOrderValueFollowersTest() {
        String incorrectOrder = "WRONG";
        User user = createUser();
        when(repository.getUserById(user.getUserId())).thenReturn(Optional.of(user));

        assertThrows(InvalidOrderException.class, () -> userService.getFollowers(user.getUserId(), incorrectOrder));
        verify(repository, Mockito.times(1)).getUserById(user.getUserId());
    }


    @DisplayName("Verifica el correcto ordenamiento ascendente por nombre de los seguidos")//T-0004
    @Test
    public void correctOrderAscFollowedsTest() {

        User user1 = createUser();
        user1.setFolloweds(createUserList());

        when(repository.getUserById(user1.getUserId())).thenReturn(Optional.of(user1));

        FollowedsDTO result = userService.getFollowedUsers(user1.getUserId(), NAME_ASC);
        List<User> expected = user1.getFolloweds();
        Collections.reverse(expected);

        assertArrayEquals(Mapper.userToUserDtoList(expected).toArray(), result.getFollowed().toArray());
        verify(repository, Mockito.times(1)).getUserById(user1.getUserId());
    }

    @DisplayName("Verifica el correcto ordenamiento descendente por nombre de los seguidos")//T-0004
    @Test
    public void correctOrderDescFollowedsTest() {

        User user1 = createUser();
        user1.setFolloweds(createUserList());

        when(repository.getUserById(user1.getUserId())).thenReturn(Optional.of(user1));

        FollowedsDTO result = userService.getFollowedUsers(user1.getUserId(), NAME_DESC);
        List<User> expected = user1.getFolloweds();

        assertArrayEquals(Mapper.userToUserDtoList(expected).toArray(), result.getFollowed().toArray());
        verify(repository, Mockito.times(1)).getUserById(user1.getUserId());
    }

    @DisplayName("Verifica el correcto ordenamiento ascendente por nombre de los seguidores")//T-0004
    @Test
    public void correctOrderAscFollowersTest() {

        User user1 = createUser();
        user1.setFollowers(createUserList());
        when(repository.getUserById(user1.getUserId())).thenReturn(Optional.of(user1));

        FollowersDTO result = userService.getFollowers(user1.getUserId(), NAME_ASC);
        List<User> expected = user1.getFollowers();
        Collections.reverse(expected);

        assertArrayEquals(Mapper.userToUserDtoList(expected).toArray(), result.getFollowers().toArray());
        verify(repository, Mockito.times(1)).getUserById(user1.getUserId());
    }

    @DisplayName("Verifica el correcto ordenamiento descendente por nombre de los seguidores")//T-0004
    @Test
    public void correctOrderDescFollowersTest() {
        User user1 = createUser();
        user1.setFollowers(createUserList());
        when(repository.getUserById(user1.getUserId())).thenReturn(Optional.of(user1));

        FollowersDTO result = userService.getFollowers(user1.getUserId(), NAME_DESC);
        List<User> expected = user1.getFollowers();

        assertArrayEquals(Mapper.userToUserDtoList(expected).toArray(), result.getFollowers().toArray());
        verify(repository, Mockito.times(1)).getUserById(user1.getUserId());
    }

    @DisplayName("Verifica que el usuario a seguir exista")//T-0001
    @Test
    void followingUserExistTest() {

        //arrange
        User user1 = createUser();
        User user2 = createSeller();

        when(repository.getUserById(Mockito.anyInt())).thenReturn(Optional.of(user1), Optional.of(user2));

        //act
        userService.followUser(user1.getUserId(), user2.getUserId());

        //assert
        Assertions.assertTrue(user2.getFollowers().contains(user1) && user1.getFolloweds().contains(user2));
    }

    @DisplayName("Notifica la no existencia del usuario a seguir mediante una excepción.")//T-0001
    @Test
    void followExceptionWhenUserNotExist() {

        //arrange
        User user1 = createUser();
        User user2 = createSeller();

        when(repository.getUserById(1)).thenReturn(Optional.of(user1));

        //act
        //assert
        Assertions.assertThrows(UserNotExistException.class, () -> userService.followUser(user1.getUserId(), user2.getUserId()));
    }

    @DisplayName("Verifica que el usuario a dejar de seguir exista")//T-0002
    @Test
    void unfollowingUserExistTest() {

        //arrange
        User user1 = createUser();
        User user2 = createSeller();
        user1.getFolloweds().add(user2);
        user2.getFollowers().add(user1);

        when(repository.getUserById(Mockito.anyInt())).thenReturn(Optional.of(user1), Optional.of(user2));

        //act
        userService.unfollowUser(user1.getUserId(), user2.getUserId());

        //assert
        Assertions.assertTrue(!user2.getFollowers().contains(user1) && !user1.getFolloweds().contains(user2));
    }

    @DisplayName("Notifica la no existencia del usuario a seguir mediante una excepción.")//T-0002
    @Test
    void unfollowExceptionWhenUserNotExist() {

        //arrange
        User user1 = createUser();
        User user2 = createSeller();

        when(repository.getUserById(1)).thenReturn(Optional.of(user1));

        //act
        //assert
        Assertions.assertThrows(UserNotExistException.class, () -> userService.unfollowUser(user1.getUserId(), user2.getUserId()));
    }

    @DisplayName("Verifica que la cantidad de seguidores de un determinado usuario sea correcta")//T-0007
    @Test
    public void getcountFollowersTest() {

        User user = createUser();
        User userFollower = createSeller();
        user.setFollowers(List.of(userFollower));

        when(repository.getUserById(1)).thenReturn(Optional.of(user));


        FollowerCountDTO followerCountDTO = userService.getCountFollowers(1);
        Assertions.assertAll(
                () -> assertEquals(user.getFollowers().size(), followerCountDTO.getFollowersCount(), "Assert 1: Followers iguales "),
                () -> assertEquals(user.getUserName(), followerCountDTO.getUserName(), "Assert 2: UserName igual"),
                () -> assertEquals(user.getUserId(), followerCountDTO.getUserId(), "Assert 3: UserId igual")
        );

    }


}
