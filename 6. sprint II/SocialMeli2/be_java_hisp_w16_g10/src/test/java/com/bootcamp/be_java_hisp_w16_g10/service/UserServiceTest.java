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
    @DisplayName("Testing follow yourself")
    void shouldRaiseBadRequestExceptionWhenTwoIdsAreEquals() {
        BadRequestException badRequestException = assertThrows(
                BadRequestException.class,
                () -> this.userService.follow(1, 1)
        );
        assertEquals("Cannot follow yourself", badRequestException.getMessage());
    }

    @Test
    @DisplayName("Testing follow a non existing user")
    void shouldRaiseAnExceptionWhenTheUserDoesNotExists() {
        when(this.userRepository.findById(1)).thenReturn(null);
        NotFoundException notFoundException = assertThrows(NotFoundException.class,
                () ->this.userService.follow(1, 2)
        );
        assertEquals(String.format("The user with id: %s don't exists.", 1), notFoundException.getMessage());
    }
    
    @Test
    void shouldRaiseAnExceptionWhenTheUserToFollowDoesNotExists() {
        when(this.userRepository.findById(1)).thenReturn(Factory.generateUser(1));
        when(this.userRepository.findById(2)).thenReturn(null);

        NotFoundException notFoundException = assertThrows(NotFoundException.class,
                () ->this.userService.follow(1, 2)
        );

        assertEquals(String.format("The user with id: %s don't exists.", 2), notFoundException.getMessage());
    }

    @Test
    void shouldRaiseAnExceptionWhenTheUserAlreadyFollowTheUser() {
        User user = new User(1,"Ale",new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"Mati",null,null);   
        user.getFollowed().add(user2);   
        when(this.userRepository.findById(1)).thenReturn(user);
        when(this.userRepository.findById(2)).thenReturn(user2);

        BadRequestException badRequestException = assertThrows(BadRequestException.class,
                () -> this.userService.follow(1, 2)
        );

        assertEquals("Can't follow a user you already follow.", badRequestException.getMessage());
    }
    @Test
    void shouldRaiseAnExceptionWhenTheUserToFollowIsNotASeller() {
        User user = Factory.generateUser(1);
        when(this.userRepository.findById(1)).thenReturn(user);
        when(this.userRepository.findById(2)).thenReturn(Factory.generateUser(2));

        BadRequestException badRequestException = assertThrows(BadRequestException.class,
                () -> this.userService.follow(2, 1)
        );

        assertEquals(String.format("The user with the id %s is not a seller.", 1), badRequestException.getMessage());
    }
    @Test
    void shouldFollowTheUser() {
        User user = Factory.generateUserWithFollowers(1);
        when(this.userRepository.findById(1)).thenReturn(user);
        User userToFollow = Factory.generateUser(2);
        when(this.userRepository.findById(2)).thenReturn(userToFollow);
        when(this.postService.findByUserId(1)).thenReturn(Factory.generateListPostResDTO(3, 1));
        this.userService.follow(2, 1);
        verify(this.userRepository, atMostOnce()).update(user);
        verify(this.userRepository, atMostOnce()).update(userToFollow);
    }


    @Test
    @DisplayName("Throw not found exception when User not found")
    void shouldThrowNotFoundException_whenUserNotFound() {
        //Arrange
        int id = anyInt();
        //Act
        when(userRepository.findById(id)).thenReturn(null);
        //Assert
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> userService.findById(id));
        verify(userRepository, atLeastOnce()).findById(id);
        assertEquals(String.format("The user with id: %s don't exists.", id), notFoundException.getMessage());
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
       var id = anyInt();

      //act
      when(userRepository.findById(id)).thenReturn(null);
       NotFoundException notFoundException =  assertThrows(NotFoundException.class, ()-> {
           userService.validateUser(id);
      });

       assertEquals(String.format("The user with id: %s don't exists.", id), notFoundException.getMessage());
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
      BadRequestException badRequestException =  assertThrows(BadRequestException.class, ()-> {
         userService.unfollow(1, 1);   
      });
      assertEquals("Cannot unfollow yourself", badRequestException.getMessage());
   }

   @Test
   void shouldRiseBadRequestException_whenTheUserIsNotBeingFollowed(){

      //arrange

      User userToUnfollow = new User(1,"Ale",new ArrayList<>(), new ArrayList<>());
      User user = new User(2,"Giani",new ArrayList<>(),new ArrayList<>());   


      //act

      when(userRepository.findById(1)).thenReturn(user);   
      when(userRepository.findById(2)).thenReturn(userToUnfollow);

      BadRequestException badRequestException = assertThrows(BadRequestException.class, ()-> {
         userService.unfollow(1, 2);
      });

      assertEquals("The user is not being followed.", badRequestException.getMessage());
   }

   @Test
   void validateUserNotFoundCountFollowers() {
       when(this.userRepository.findById(1)).thenReturn(null);
      //assert
      NotFoundException notFoundException=  assertThrows(NotFoundException.class, () -> {
         this.userService.countFollowers(1);
      });
      assertEquals(String.format("The user with id: %s don't exists.", 1), notFoundException.getMessage());
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
      BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> userService.countFollowers(1));
        assertEquals(String.format("The user with the id %s is not a seller.", 1), badRequestException.getMessage());
   }

   @Test
   void shouldReturnBadRequestExceptionIsNotSellerInListFollowers() {
      //arrange
      var user = generateUser(1);

      //act
      when(userRepository.findById(1)).thenReturn(user);
      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

      //assert
       BadRequestException badRequestException =  assertThrows(BadRequestException.class, () -> userService.listFollowers(1,""));
      assertEquals(String.format("The user with the id %s is not a seller.", 1), badRequestException.getMessage());
   }

   @Test
   void shouldReturnBadRequestExceptionInvalidOrderInListFollowers() {
      //arrange
      var user = generateUser(1);

      //act
      when(userRepository.findById(1)).thenReturn(user);
      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(0,1));

      //assert
      BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> userService.listFollowers(1,"papa"));
      assertEquals(String.format("The user with the id %s is not a seller.", 1), badRequestException.getMessage());//TODO deberia devolver otra excption
   }

   @Test
   void shouldReturnOrderAscInListFollowers() {
      //arrange
      var user = generateUserWithFollowers(1);

      var expected = Mapper
              .parseToFollowersListResDTO(user,user.getFollowers()
              .stream()
              .sorted(Comparator.comparing(User::getUserName))
              .collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      when(postService.findByUserId(anyInt())).thenReturn(generateListPostResDTO(4,1));

      //assert
      assertEquals(expected,userService.listFollowers(1,"name_asc"));
   }

   @Test
   void shouldReturnOrderDescInListFollowers() {
      //arrange
      var user = generateUserWithFollowers(1);

      var expected = Mapper
              .parseToFollowersListResDTO(user,user.getFollowers()
                      .stream()
                      .sorted(Comparator.comparing(User::getUserName)
                              .reversed())
                      .collect(Collectors.toList()));

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
      BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> userService.listFollowed(1,"papa"));
       assertEquals(String.format("Invalid order parameter."), badRequestException.getMessage());
   }

   @Test
   void shouldReturnOrderAscInListFollowed() {
      //arrange
      var user = generateUserWithFollowed(1);

      var expected = Mapper.parseToFollowedListResDTO(user,user.getFollowed().stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      //assert
      assertEquals(expected,userService.listFollowed(1,"name_asc"));
   }

   @Test
   void shouldReturnOrderDescInListFollowed() {
      //arrange
      var user = generateUserWithFollowed(1);

      var expected = Mapper.parseToFollowedListResDTO(user,user.getFollowed().stream().sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList()));

      //act
      when(userRepository.findById(1)).thenReturn(user);

      //assert
      assertEquals(expected,userService.listFollowed(1,"name_desc"));
   }
}
