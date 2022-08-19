package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.UserResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.UserRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
import org.junit.jupiter.api.DisplayName;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w16_g10.util.Factory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    PostService postService;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Test
    @DisplayName("Testing find user by id")
    void shouldFindById() {
        //Arrange
        int id = 1;
        User user = Factory.generateUser(id);
        //Act
        when(userRepository.findById(id)).thenReturn(user);
        User result = userService.findById(id);
        //Assert
        assertEquals(result.getUserName(),user.getUserName());
        verify(userRepository, atLeastOnce()).findById(id);
    }

    @Test
    @DisplayName("Throw not found exception when User not found")
    void shouldThrowNotFoundException_whenUserNotFound() {
        //Arrange
        int id = anyInt();
        //Act
        when(userRepository.findById(id)).thenReturn(null);
        //Assert
        assertThrows(NotFoundException.class, () -> userService.findById(id));
        verify(userRepository, atLeastOnce()).findById(id);
    }

    @Test
    @DisplayName("Testing find all users")
    void findAll() {
        //Arrange
        List<User> userMocks = new ArrayList<>();
        //Act
        when(userRepository.findAll()).thenReturn(userMocks);
        List<UserResDTO> result = userService.findAll();
        //Assert
        assertEquals(userMocks.size(), result.size());
        verify(userRepository, atLeastOnce()).findAll();
    }
   @Test
   void shouldReturnAUser_whenValidateUser(){

      //arrange

      User user = User.builder()
      .id(1)
      .userName("Ale")
      .build();   

      //act
      
      when(userRepository.findById(Mockito.anyInt())).thenReturn(user);   

      //assert

      Assertions.assertThat(userService.validateUser(1).equals(user)).isTrue();

   }

   @Test
   void shouldRiseNotFoundException_whenFindByIdReturnsNull(){

      //act
      
      when(userRepository.findById(Mockito.anyInt())).thenReturn(null);   

      assertThrows(NotFoundException.class, ()-> {
         when(userService.validateUser(Mockito.anyInt())).thenReturn(Mockito.any());   
      });   
   }

   @Test
   void shouldUnfollowASeller() {

      //arrange

      User userToUnfollow = new User(1,"Ale",new ArrayList<>(), new ArrayList<>());
      User user = new User(2,"Giani",new ArrayList<>(),new ArrayList<>());   

      userToUnfollow.getFollowers().add(user);   
      user.getFollowed().add(userToUnfollow);   

      //act

      when(userRepository.findById(1)).thenReturn(user);   
      when(userRepository.findById(2)).thenReturn(userToUnfollow);   

      userService.unfollow(1, 2);

      //assertions

      Assertions.assertThat(userToUnfollow.getFollowers().size() == 0).isTrue();

   }

   @Test
   void shouldRiseBadRequestException_whenTryToUnfollowTheSameId(){
      assertThrows(BadRequestException.class, ()-> {
         userService.unfollow(1, 1);   
      });   
   }

   @Test
   void shouldRiseBadRequestException_whenTheUserIsNotBeingFollowed(){

      //arrange

      User userToUnfollow = new User(1,"Ale",new ArrayList<>(), new ArrayList<>());
      User user = new User(2,"Giani",new ArrayList<>(),new ArrayList<>());   


      //act

      when(userRepository.findById(1)).thenReturn(user);   
      when(userRepository.findById(2)).thenReturn(userToUnfollow);

      assertThrows(BadRequestException.class, ()-> {
         userService.unfollow(1, 2);
      });   
   }

   @Test
   void validateUserNotFoundCountFollowers() {
      //assert
      assertThrows(NotFoundException.class, () -> {
         when(userService.countFollowers(anyInt())).thenReturn(null);
      });
   }

   @Test
   void shouldReturnCountFollowers() {
      //arrange
      var user = generateUser(1);
      //act

      when(userRepository.findById(1)).thenReturn(user);
      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

      var res = userService.countFollowers(1);

      //assert
      assertEquals(0,res.getFollowersCount());

   }

   @Test
   void shouldReturnBadRequestExceptionInCountFollowers() {
      //arrange
      var user = generateUser(1);

      //act
      when(userRepository.findById(1)).thenReturn(user);
      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

      //assert
      assertThrows(BadRequestException.class, () -> userService.countFollowers(1));
   }

   @Test
   void shouldReturnBadRequestExceptionIsNotSellerInListFollowers() {
      //arrange
      var user = generateUser(1);

      //act
      when(userRepository.findById(1)).thenReturn(user);
      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

      //assert
      assertThrows(BadRequestException.class, () -> userService.listFollowers(1,""));
   }

   @Test
   void shouldReturnBadRequestExceptionInvalidOrderInListFollowers() {
      //arrange
      var user = generateUser(1);

      //act
      when(userRepository.findById(1)).thenReturn(user);
      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

      //assert
      assertThrows(BadRequestException.class, () -> userService.listFollowers(1,"papa"));
   }

   @Test
   void shouldReturnBadRequestExceptionOrderAscInListFollowers() {
      //arrange
      var user = generateUserWithFollowers(1);

      var expected = Mapper.parseToFollowersListResDTO(user,user.getFollowers().stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

      //assert
      assertEquals(expected,userService.listFollowers(1,"name_asc"));
   }

   @Test
   void shouldReturnBadRequestExceptionOrderDescInListFollowers() {
      //arrange
      var user = generateUserWithFollowers(1);

      var expected = Mapper.parseToFollowersListResDTO(user,user.getFollowers().stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

      //assert
      assertEquals(expected,userService.listFollowers(1,"name_desc"));
   }

   @Test
   void shouldReturnBadRequestExceptionInvalidOrderInListFollowed() {
      //arrange
      var user = generateUser(1);

      //act
      when(userRepository.findById(1)).thenReturn(user);

      //assert
      assertThrows(BadRequestException.class, () -> userService.listFollowed(1,"papa"));
   }

   @Test
   void shouldReturnBadRequestExceptionOrderAscInListFollowed() {
      //arrange
      var user = generateUserWithFollowed(1);

      var expected = Mapper.parseToFollowedListResDTO(user,user.getFollowed().stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      //assert
      assertEquals(expected,userService.listFollowed(1,"name_asc"));
   }

   @Test
   void shouldReturnBadRequestExceptionOrderDescInListFollowed() {
      //arrange
      var user = generateUserWithFollowed(1);

      var expected = Mapper.parseToFollowedListResDTO(user,user.getFollowed().stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      //assert
      assertEquals(expected,userService.listFollowed(1,"name_desc"));
   }
}
