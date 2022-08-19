package com.bootcamp.be_java_hisp_w16_g01.services;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.service.UserService;
import org.junit.jupiter.api.Test;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;

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

    @Test
    public void nameAscOrderFollowersOk(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowers(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nameDescOrderFollowersOk(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowers(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void invalidOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        assertThrows(BadRequestException.class , () -> userService.getFollowers(4, "id_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nullOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), null);

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        followers.forEach(follower -> {
            assertTrue(response.getFollowers().stream().anyMatch(u -> u.getUserId() == follower.getUserId() &&
                    u.getUserName().equals(follower.getUserName())));
        });
    }
    @Test
    public void invalidUserFollowers(){
        User user = new User(44, "user 44");

        //arrange
        when(userRepository.getUser(user.getUserId())).thenReturn(null);

        // act & assert
        assertThrows(BadRequestException.class , () -> userService.getFollowers(user.getUserId(), "name_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void verifyNameAscOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowers().size() ; i++){
            assertEquals(response.getFollowers().get(i).getUserName(), followers.get(i).getUserName());
            assertEquals(response.getFollowers().get(i).getUserId(), followers.get(i).getUserId());
        }

    }
    @Test
    public void verifyNameDescOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(2, "sofia"));
        followers.add(new User(1, "juan"));
        followers.add(new User(3, "alberto"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowers().size() ; i++){
            assertEquals(response.getFollowers().get(i).getUserName(), followers.get(i).getUserName());
            assertEquals(response.getFollowers().get(i).getUserId(), followers.get(i).getUserId());
        }
    }

    @Test
    public void nameAscOrderFollowedOk(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowed(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nameDescOrderFollowedOk(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowed(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void invalidOrderFollowed(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        assertThrows(BadRequestException.class , () -> userService.getFollowed(4, "id_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nullOrderFollowed(){
        List<User> followed= new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), null);

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        followed.forEach(follow -> {
            assertTrue(response.getFollowed().stream().anyMatch(u -> u.getUserId() == follow.getUserId() &&
                    u.getUserName().equals(follow.getUserName())));
        });
    }

    @Test
    public void invalidUserFollowed(){
        User user = new User(44, "user 44");

        //arrange
        when(userRepository.getUser(user.getUserId())).thenReturn(null);

        // act & assert
        assertThrows(BadRequestException.class , () -> userService.getFollowed(user.getUserId(), "name_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void verifyNameAscOrderFollowed(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowed().size() ; i++){
            assertEquals(response.getFollowed().get(i).getUserName(), followed.get(i).getUserName());
            assertEquals(response.getFollowed().get(i).getUserId(), followed.get(i).getUserId());
        }
    }
    @Test
    public void verifyNameDescOrderFollowed(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(2, "sofia"));
        followed.add(new User(1, "juan"));
        followed.add(new User(3, "alberto"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowed().size() ; i++){
            assertEquals(response.getFollowed().get(i).getUserName(), followed.get(i).getUserName());
            assertEquals(response.getFollowed().get(i).getUserId(), followed.get(i).getUserId());
        }
    }
}
