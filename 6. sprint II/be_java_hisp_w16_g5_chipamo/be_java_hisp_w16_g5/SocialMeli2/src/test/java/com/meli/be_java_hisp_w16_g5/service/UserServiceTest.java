package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.UserDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowsDto;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.repository.UserRepository;
import com.meli.be_java_hisp_w16_g5.dto.*;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Assert;
import static org.junit.Assert.assertThrows;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void getCountFollowsTestGod() throws UserNotFoundException {
        int expectedCount = 3;
        User userFollower = new User(2, "Rodrigo", null, null, null);
        User userFollower2 = new User(4, "Rodrigo", null, null, null);
        User userFollower3 = new User(4, "Rodrigo", null, null, null);
        User userExpect = new User();
        userExpect.setUserName("Gae");
        userExpect.setUserId(1);
        List<User> followers = new ArrayList<>();
        followers.add(userFollower);
        followers.add(userFollower2);
        followers.add(userFollower3);
        userExpect.setFollowers(followers);
        when(userRepository.findUserById(1)).thenReturn(userExpect);
        UserDto currentCount = userService.getCountFollows(1);
        verify(userRepository, atLeast(1)).findUserById(1);
        assertThat(expectedCount).isEqualTo(currentCount.getFollowersCount());
    }

    @Test
    void getCountFollowsBad() throws UserNotFoundException {
        int expectedCount = 0;
        User userExpect = new User();
        userExpect.setUserName("Gae");
        userExpect.setUserId(1);
        when(userRepository.findUserById(1)).thenReturn(userExpect);
        UserDto currentCount = userService.getCountFollows(1);
        verify(userRepository, atLeast(1)).findUserById(1);
        assertThat(expectedCount).isEqualTo(currentCount.getFollowersCount());
    }

    @Test
    void unfollowTest() throws UserNotFoundException {
        User userExpect = new User(1, "Gae", null, null, null);
        User userExpect2 = new User(2, "sebastian", null, null, null);
        List<User> followers = new ArrayList<>();
        List<User> following = new ArrayList<>();
        followers.add(userExpect2);
        following.add(userExpect);
        userExpect.setFollowers(followers);
        userExpect2.setFollowing(following);
        UserFollowsDto userFollowsDtoExpect = new UserFollowsDto("Todo ok");
        when(userRepository.findUserById(1)).thenReturn(userExpect);
        when(userRepository.findUserById(2)).thenReturn(userExpect2);
        UserFollowsDto userFollowsDto = userService.setUnfollowUser(1, 2);
        verify(userRepository, atLeast(1)).findUserById(1);
        verify(userRepository, atLeast(1)).findUserById(2);
        assertThat(userFollowsDtoExpect.getMensaje()).isEqualTo(userFollowsDto.getMensaje());
    }

    /**
     * Testing getFollowing
     * US 0004: Metodo que obtiene un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     */
    @Test
    void getFollowingSortedAsc() throws UserNotFoundException{
        //Arrange
       User user = UtilTestTools.createCompletedUser("Gae", 1);
       Integer sortCondition = Util.getSortCondition("name_asc", "name");

       List<FollowedDto> followed = user.getFollowing().stream()
       .map( follower -> new FollowedDto(follower.getUserId(), follower.getUserName()) )
       .collect(Collectors.toList());

       followed.sort(
           (FollowedDto f1, FollowedDto f2) -> f1.getUserName().compareTo(f2.getUserName()) * sortCondition
       );

       when(userRepository.findUserById(1)).thenReturn(user);

       //Act
       UserFollowedDto userFollowedDtoResult = userService.getFollowingSorted(1, "name_asc");
       
       //Asserts
       assertEquals(followed, userFollowedDtoResult.getFollowed());

    }

    @Test
    void getFollowingSortedDesc() throws UserNotFoundException{
        //Arrange
       User user = UtilTestTools.createCompletedUser("Gae", 1);
       Integer sortCondition = Util.getSortCondition("name_desc", "name");

       List<FollowedDto> followed = user.getFollowing().stream()
       .map( follower -> new FollowedDto(follower.getUserId(), follower.getUserName()) )
       .collect(Collectors.toList());

       followed.sort(
           (FollowedDto f1, FollowedDto f2) -> f1.getUserName().compareTo(f2.getUserName()) * sortCondition
       );

       when(userRepository.findUserById(1)).thenReturn(user);

       //Act
       UserFollowedDto userFollowedDtoResult = userService.getFollowingSorted(1, "name_desc");
       
       //Asserts
       assertEquals(followed, userFollowedDtoResult.getFollowed());
    }

    @Test
    void getFollowingSorted() throws UserNotFoundException{
       //Arrange
       User user = UtilTestTools.createCompletedUser("Gae", 1);

       List<FollowedDto> followed = user.getFollowing().stream()
       .map( follower -> new FollowedDto(follower.getUserId(), follower.getUserName()) )
       .collect(Collectors.toList());

       when(userRepository.findUserById(1)).thenReturn(user);

       //Act
       UserFollowedDto userFollowedDtoResult = userService.getFollowingSorted(1, null);
       
       //Asserts
       assertEquals(followed, userFollowedDtoResult.getFollowed());
    }

    @Test
    void getFollowingSortedException(){
        //Arrange
        String expectedMessage= "Usuario no encontrado";

        when(userRepository.findUserById(1)).thenReturn(null);

        //Act
        Exception exception = Assert.assertThrows(UserNotFoundException.class,
                ()->userService.getFollowingSorted(1,""));
       //Asserts
        assertEquals(expectedMessage,exception.getMessage());

    }

    void testFindUserFollowSellerOK() throws UserNotFoundException {//T-0001 de us-0001 (Se cumple)
        //Arrange
        int userIdTest = 2;

        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Gae");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Johannes");

        List<User> userDtoList = new ArrayList<>();
        userDtoList.add(user1);
        userDtoList.add(user2);

        UserFollowsDto userFollowsDto= new UserFollowsDto();
        userFollowsDto.setMensaje("Usuario: Gae siguiendo a: Johannes");

        when(userRepository.findUserById(userIdTest)).thenReturn(user2);
        when(userRepository.findUserById(1)).thenReturn(user1);

        //Act
        UserFollowsDto exec = userService.setUserFollowSeller(userDtoList.get(0).getUserId(),userDtoList.get(1).getUserId());

        //Assert
        assertEquals(exec.getMensaje(), userFollowsDto.getMensaje());


    }

    @Test
    void unfollowTestNull() throws UserNotFoundException {

        when(userRepository.findUserById(1)).thenReturn(null);
        when(userRepository.findUserById(2)).thenReturn(null);
        Exception exception =  assertThrows(UserNotFoundException.class,()->userService.setUnfollowUser(1,2));
        verify(userRepository, atLeast(1)).findUserById(1);
        verify(userRepository, atLeast(1)).findUserById(2);
        String messageExpect = "El usuario: 1 no existe.";


       String messageRecibe= exception.getMessage();
       assertEquals(messageExpect,messageRecibe);
    }

    @Test
    void testFindUserFollowSellerNotOK() throws UserNotFoundException {//T-0001 de us-0001 (No se cumple)
        //Arrange
        int userIdTest = 3;

        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Gae");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Johannes");

        List<User> userDtoList = new ArrayList<>();
        userDtoList.add(user1);
        userDtoList.add(user2);

        when(userRepository.findUserById(userIdTest)).thenReturn(user2);
        when(userRepository.findUserById(1)).thenReturn(user1);
        when(userRepository.findUserById(3)).thenReturn(null);

        //Act
        Exception exception = assertThrows(UserNotFoundException.class,()->userService.setUserFollowSeller(userDtoList.get(0).getUserId(),userIdTest));
        String expectedMsg = "El vendedor a seguir: 3 no existe.";
        String actualMsg = exception.getMessage();

        //Assert
        assertEquals(expectedMsg, actualMsg);
    }

      /**
     * Testing getFollowers
     * US 0003: Metodo que obtiene un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     */
    @Test
    void getFollowersSortedAsc() throws UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUser("Gae", 1);
        Integer sortCondition = Util.getSortCondition("name_asc", "name");

        List<FollowerDto> followers = user.getFollowers().stream()
        .map( follower -> new FollowerDto(follower.getUserId(), follower.getUserName()) )
        .collect(Collectors.toList());

        followers.sort(
            (FollowerDto f1, FollowerDto f2) -> f1.getUserName().compareTo(f2.getUserName()) * sortCondition
        );

        when(userRepository.findUserById(1)).thenReturn(user);

        //Act
        UserFollowerDto userFollowedDtoResult = userService.getFollowersSorted(1, "name_asc");
        
        //Asserts
        assertEquals(followers, userFollowedDtoResult.getFollowers());
    
    }

    @Test
    void getFollowersSortedDesc() throws UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUser("Gae", 1);
        Integer sortCondition = Util.getSortCondition("name_desc", "name");

        List<FollowerDto> followers = user.getFollowers().stream()
        .map( follower -> new FollowerDto(follower.getUserId(), follower.getUserName()) )
        .collect(Collectors.toList());

        followers.sort(
            (FollowerDto f1, FollowerDto f2) -> f1.getUserName().compareTo(f2.getUserName()) * sortCondition
        );

        when(userRepository.findUserById(1)).thenReturn(user);

        //Act
        UserFollowerDto userFollowedDtoResult = userService.getFollowersSorted(1, "name_desc");
        
        //Asserts
        assertEquals(followers, userFollowedDtoResult.getFollowers());
    }

    @Test
    void getFollowersSorted() throws UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUser("Gae", 1);
        List<FollowerDto> followers = user.getFollowers().stream()
        .map( follower -> new FollowerDto(follower.getUserId(), follower.getUserName()) )
        .collect(Collectors.toList());

        when(userRepository.findUserById(1)).thenReturn(user);

        //Act
        UserFollowerDto userFollowedDtoResult = userService.getFollowersSorted(1,null);
        
        //Asserts
        assertEquals(followers, userFollowedDtoResult.getFollowers());
    }

    @Test
    void getFollowersSortedException(){
        //Arrange
        String expectedMessage= "Usuario no encontrado";

        when(userRepository.findUserById(1)).thenReturn(null);

        //Act
        Exception exception = Assert.assertThrows(UserNotFoundException.class,
                ()->userService.getFollowersSorted(1,null));

        //Asserts
        assertEquals(expectedMessage,exception.getMessage());

    }

     // T0003 - 1 - Given a unkown sort order, throw an exception
     @Test
     void getFollowingUnknownSortedWithHandleException() throws UnknownRequestException, UserNotFoundException{
 
         //Arrange
         User expectedUser = UtilTestTools.createCompletedUser("Gae", 1);
 
         when(userRepository.findUserById(1)).thenReturn(expectedUser);
 
         //Act
         Exception exception = assertThrows(UnknownRequestException.class, () -> userService.getFollowingSorted(expectedUser.getUserId(), "unknown"));
 
         //Asserts
         assertTrue(exception.getMessage().equals("Unknown order: unknown"));
 
     }
}

