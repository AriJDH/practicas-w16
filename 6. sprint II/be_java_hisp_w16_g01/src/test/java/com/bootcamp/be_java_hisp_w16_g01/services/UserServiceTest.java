package com.bootcamp.be_java_hisp_w16_g01.services;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryUser;
import org.junit.jupiter.api.BeforeEach;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowersCountDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    public void nameAscOrderFollowersTest(){

        User user = FactoryUser.getUserWithFollowersAsc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowers(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nameDescOrderFollowersTest(){

        User user = FactoryUser.getUserWithFollowersDesc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowers(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void invalidOrderFollowersTest(){

        User user = FactoryUser.getUserWithFollowers();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        assertThrows(BadRequestException.class , () -> userService.getFollowers(4, "id_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nullOrderFollowersTest(){

        User user = FactoryUser.getUserWithFollowers();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), null);

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        user.getFollowers().forEach(follower -> {
            assertTrue(response.getFollowers().stream().anyMatch(u -> u.getUserId() == follower.getUserId() &&
                    u.getUserName().equals(follower.getUserName())));
        });
    }
    @Test
    public void invalidUserFollowersTest(){
        User user = new User(44, "user 44");

        //arrange
        when(userRepository.getUser(user.getUserId())).thenReturn(null);

        // act & assert
        assertThrows(BadRequestException.class , () -> userService.getFollowers(user.getUserId(), "name_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void verifyNameAscOrderFollowersTest(){

        User user = FactoryUser.getUserWithFollowersAsc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowers().size() ; i++){
            assertEquals(response.getFollowers().get(i).getUserName(), user.getFollowers().get(i).getUserName());
            assertEquals(response.getFollowers().get(i).getUserId(), user.getFollowers().get(i).getUserId());
        }

    }
    @Test
    public void verifyNameDescOrderFollowersTest(){

        User user = FactoryUser.getUserWithFollowersDesc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowers().size() ; i++){
            assertEquals(response.getFollowers().get(i).getUserName(), user.getFollowers().get(i).getUserName());
            assertEquals(response.getFollowers().get(i).getUserId(), user.getFollowers().get(i).getUserId());
        }
    }

    @Test
    public void nameAscOrderFollowedTest(){

        User user = FactoryUser.getUserWithFollowedAsc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowed(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nameDescOrderFollowedTest(){

        User user = FactoryUser.getUserWithFollowedDesc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowed(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void invalidOrderFollowedTest(){

        User user = FactoryUser.getUserWithFollowed();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        assertThrows(BadRequestException.class , () -> userService.getFollowed(4, "id_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nullOrderFollowedTest(){
        User user = FactoryUser.getUserWithFollowed();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), null);

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        user.getFollowed().forEach(follow -> {
            assertTrue(response.getFollowed().stream().anyMatch(u -> u.getUserId() == follow.getUserId() &&
                    u.getUserName().equals(follow.getUserName())));
        });
    }

    @Test
    public void invalidUserFollowedTest(){
        User user = new User(44, "user 44");

        //arrange
        when(userRepository.getUser(user.getUserId())).thenReturn(null);

        // act & assert
        assertThrows(BadRequestException.class , () -> userService.getFollowed(user.getUserId(), "name_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void verifyNameAscOrderFollowedTest(){

        User user = FactoryUser.getUserWithFollowedAsc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowed().size() ; i++){
            assertEquals(response.getFollowed().get(i).getUserName(), user.getFollowed().get(i).getUserName());
            assertEquals(response.getFollowed().get(i).getUserId(), user.getFollowed().get(i).getUserId());
        }
    }

    @Test
    public void verifyNameDescOrderFollowedTest(){

        User user = FactoryUser.getUserWithFollowedDesc();

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowed().size() ; i++){
            assertEquals(response.getFollowed().get(i).getUserName(), user.getFollowed().get(i).getUserName());
            assertEquals(response.getFollowed().get(i).getUserId(), user.getFollowed().get(i).getUserId());
        }
    }

    @Test
    @DisplayName("El usuario no existe")
    public void userNotExistTest() {
        //Arrange
        Integer userId = 1;
        when(userRepository.userExists(userId)).thenReturn(false);
        //Assert & Act
        assertThrows(BadRequestException.class, () -> userService.getCantFollowers(userId));
    }

    @Test
    @DisplayName("El usuario existe")
    public void userExistTest() {
        //Arrange
        Integer userId = 1;

        User userFollowed = new User(userId, "user 4");
        FollowersCountDTO expectedUser = FactoryUser.getFollowersCountDTO(userFollowed);

        when(userRepository.userExists(userId)).thenReturn(true);
        when(userRepository.getUser(userId)).thenReturn(userFollowed);
        //Act
        FollowersCountDTO result = userService.getCantFollowers(userId);
        //Assert
        assertEquals(expectedUser.getFollowersCount(), result.getFollowersCount());
        verify(userRepository, atLeastOnce()).userExists(userId);
        verify(userRepository, atLeastOnce()).getUser(userId);
    }

    @Test
    public void addFollowerUserExistsTest() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        MessageDto expected = new MessageDto("Usuario seguido correctamente");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);
        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(true);
        when(userRepository.userIsSeller(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.getUser(user.getUserId()))
                .thenReturn(user);

        when(userRepository.getUser(userToFollow.getUserId()))
                .thenReturn(userToFollow);

        // Act
        MessageDto result = userService.addFollower(user.getUserId(), userToFollow.getUserId());

        // Assert
        verify(userRepository, atLeast(1)).userExists(user.getUserId());
        verify(userRepository, atLeast(1)).userExists(userToFollow.getUserId());
        verify(userRepository, atLeast(1)).userIsSeller(userToFollow.getUserId());
        verify(userRepository, atLeast(1)).getUser(user.getUserId());
        verify(userRepository, atLeast(1)).getUser(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).addFollower(user.getUserId(), userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).addFollowed(user.getUserId(), userToFollow.getUserId());

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addFollowerUserDoesNotExistTest() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
    }


    @Test
    public void addFollowerUserToFollowDoesNotExistTest() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);

        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
        verify(userRepository, atLeastOnce()).userExists(userToFollow.getUserId());
    }

    @Test
    public void addFollowerUserToFollowIsNotASellerTest() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);

        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.userIsSeller(userToFollow.getUserId()))
                .thenReturn(false);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
        verify(userRepository, atLeastOnce()).userExists(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).userIsSeller(userToFollow.getUserId());
    }
    @Test
    public void addFollowerUserAlreadyFollowsUserToFollowTest() {
        // Arrange
        User user = new User(1, "Juan");
        User userToFollow = new User(2, "Jose");
        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        when(userRepository.userExists(user.getUserId()))
                .thenReturn(true);

        when(userRepository.userExists(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.userIsSeller(userToFollow.getUserId()))
                .thenReturn(true);

        when(userRepository.getUser(user.getUserId()))
                .thenReturn(user);

        when(userRepository.getUser(userToFollow.getUserId()))
                .thenReturn(userToFollow);

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.addFollower(user.getUserId(), userToFollow.getUserId()));
        verify(userRepository, atLeastOnce()).userExists(user.getUserId());
        verify(userRepository, atLeastOnce()).userExists(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).userIsSeller(userToFollow.getUserId());
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        verify(userRepository, atLeastOnce()).getUser(userToFollow.getUserId());
    }
}
