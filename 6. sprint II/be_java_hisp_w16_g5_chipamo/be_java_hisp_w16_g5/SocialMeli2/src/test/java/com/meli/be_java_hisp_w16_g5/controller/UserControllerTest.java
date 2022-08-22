package com.meli.be_java_hisp_w16_g5.controller;


import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.service.IUserService;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowedDto;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.dto.FollowedDto;
import com.meli.be_java_hisp_w16_g5.dto.FollowerDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowerDto;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    IUserService userService;
    @InjectMocks
    UserController userController;

    /**
     * Testing getFollowing
     * US 0004: Metodo que obtiene un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     */
    @Test
    void getFollowedsListAsc() throws UserNotFoundException {
        //Arrange
        int id=1;
        String order="name_asc";

        UserFollowedDto expectedUserFollowedDto= new UserFollowedDto();

        expectedUserFollowedDto.setUserId(1);
        expectedUserFollowedDto.setUserName("Gae");

        List<FollowedDto> followers = new ArrayList<>();
        FollowedDto user1 = new FollowedDto(3,"Burr");
        FollowedDto user2 = new FollowedDto(4,"Marcos");
        followers.add(user1);
        followers.add(user2);
        expectedUserFollowedDto.setFollowed(followers);

        when(userService.getFollowingSorted(id,order)).thenReturn(expectedUserFollowedDto);

        //Act
        ResponseEntity<UserFollowedDto> respuesta = userController.getFollowedsList(1,order);

        //Asserts
        Assert.assertEquals(HttpStatus.OK,respuesta.getStatusCode());
        Assert.assertEquals(expectedUserFollowedDto,respuesta.getBody());
        verify(userService,atLeastOnce()).getFollowingSorted(id,order);
    }

    @Test
    void getFollowedsListDesc() throws UserNotFoundException {
        //Arrange
        int id=1;
        String order="name_desc";

        UserFollowedDto expecteduserFollowedDto= new UserFollowedDto();
        expecteduserFollowedDto.setUserId(1);
        expecteduserFollowedDto.setUserName("Gae");

        List<FollowedDto> followers = new ArrayList<>();
        FollowedDto user1 = new FollowedDto(3,"Burr");
        FollowedDto user2 = new FollowedDto(4,"Marcos");
        followers.add(user2);
        followers.add(user1);
        expecteduserFollowedDto.setFollowed(followers);


        when(userService.getFollowingSorted(id,order)).thenReturn(expecteduserFollowedDto);
        //Act
        ResponseEntity<UserFollowedDto> respuesta = userController.getFollowedsList(1,order);

        //Asserts
        Assert.assertEquals(HttpStatus.OK,respuesta.getStatusCode() );
        Assert.assertEquals(expecteduserFollowedDto,respuesta.getBody());
        Assert.assertEquals(expecteduserFollowedDto.getFollowed().get(0).getUserID(),
                respuesta.getBody().getFollowed().get(0).getUserID()
                );

        verify(userService,atLeastOnce()).getFollowingSorted(id,order);
    }

    @Test
    void getFollowedsList() throws UserNotFoundException{
        //Arrange
        int id=1;
        String order = null;

        UserFollowedDto expecteduserFollowedDto= new UserFollowedDto();
        expecteduserFollowedDto.setUserId(1);
        expecteduserFollowedDto.setUserName("Gae");

        List<FollowedDto> followers = new ArrayList<>();
        FollowedDto user1 = new FollowedDto(3,"Burr");
        FollowedDto user2 = new FollowedDto(4,"Marcos");
        followers.add(user1);
        followers.add(user2);
        expecteduserFollowedDto.setFollowed(followers);

        when(userService.getFollowingSorted(id,order)).thenReturn(expecteduserFollowedDto);

        //Act
        ResponseEntity<UserFollowedDto> respuesta = userController.getFollowedsList(1,order);

        //Asserts
        Assert.assertEquals( HttpStatus.OK,respuesta.getStatusCode());
        Assert.assertEquals(expecteduserFollowedDto,respuesta.getBody());
        verify(userService,atLeastOnce()).getFollowingSorted(id,order);
    }

    /**
     * Testing getFollowers
     * US 0003: Metodo que obtiene un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     */
    @Test
    void getFollowersListAsc() throws UserNotFoundException {
        //Arrange
        int id = 1;
        String order = "name_asc";
        Integer sortCondition = Util.getSortCondition(order, "name");

        User user = UtilTestTools.createCompletedUser("Gae", id);
        List<FollowerDto> followers = user.getFollowers().stream()
        .map( follower -> new FollowerDto(follower.getUserId(), follower.getUserName()) )
        .collect(Collectors.toList());

        
        UserFollowerDto expected = new UserFollowerDto(user.getUserId(), user.getUserName(), followers);
        when(userService.getFollowersSorted(id, order)).thenReturn(expected);
        
        followers.sort( (follower1, follower2) ->  follower1.getUserName().compareTo(follower2.getUserName()) * sortCondition);
        

        //Act
        UserFollowerDto userFollowedDtoResult = userController.getFollowers(id, order).getBody();
        
        //Asserts
        verify(userService, atLeastOnce()).getFollowersSorted(id, order);
        assertEquals(expected, userFollowedDtoResult);
    }

    @Test
    void getFollowersListDesc() throws UserNotFoundException {
        //Arrange
        int id = 1;
        String order = "name_desc";
        Integer sortCondition = Util.getSortCondition(order, "name");

        User user = UtilTestTools.createCompletedUser("Gae", id);
        List<FollowerDto> followers = user.getFollowers().stream()
        .map( follower -> new FollowerDto(follower.getUserId(), follower.getUserName()) )
        .collect(Collectors.toList());

        
        UserFollowerDto expected = new UserFollowerDto(user.getUserId(), user.getUserName(), followers);
        when(userService.getFollowersSorted(id, order)).thenReturn(expected);
        
        followers.sort( (follower1, follower2) ->  follower1.getUserName().compareTo(follower2.getUserName()) * sortCondition);
        

        //Act
        UserFollowerDto userFollowedDtoResult = userController.getFollowers(id, order).getBody();
        
        //Asserts
        verify(userService, atLeastOnce()).getFollowersSorted(id, order);
        assertEquals(expected, userFollowedDtoResult);

    }

    @Test
    void getFollowersList() throws UserNotFoundException {
        //Arrange
        int id = 1;
        String order = null;

        User user = UtilTestTools.createCompletedUser("Gae", id);
        List<FollowerDto> followers = user.getFollowers().stream()
        .map( follower -> new FollowerDto(follower.getUserId(), follower.getUserName()) )
        .collect(Collectors.toList());

        
        UserFollowerDto expected = new UserFollowerDto(user.getUserId(), user.getUserName(), followers);
        when(userService.getFollowersSorted(id, order)).thenReturn(expected);
                
        //Act
        UserFollowerDto userFollowedDtoResult = userController.getFollowers(id, order).getBody();
        
        //Asserts
        verify(userService, atLeastOnce()).getFollowersSorted(id, order);
        assertEquals(expected, userFollowedDtoResult);
    }
    
     @Test
    public void testSetUserFollowSeller() throws UserNotFoundException {
        //Act
        userController.setUserFollowSeller(1,2);
        //Assert
        verify(userService, atLeastOnce()).setUserFollowSeller(1,2);
    }
    
    // T0003 - 1 - Given a unknown sort order, throw an exception
    @Test
    public void getFollowingUnknownSortedWithHandleException() throws UnknownRequestException, UserNotFoundException{

        //Arrange
        User expectedUser = UtilTestTools.createCompletedUser("Gae", 1);
        
        
        when(userService.getFollowingSorted(expectedUser.getUserId(), "unknown"))
        .thenThrow(new UnknownRequestException("Unknown order: unknown"));
        
        //Act
        Exception exception = assertThrows(UnknownRequestException.class, () -> userController.getFollowedsList(expectedUser.getUserId(), "unknown"));
        
        //Asserts
        verify(userService, atLeastOnce()).getFollowingSorted(expectedUser.getUserId(), "unknown");
        assertTrue(exception.getMessage().equals("Unknown order: unknown"));
        
    }
   

}
