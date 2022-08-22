package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.OrderNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  @Mock
  IUserRepository iUserRepository;

  @Mock
  IFollowerRepository iFollowerRepository;

  @InjectMocks
  UserService userService;

  @Test
  public void getListFollowersByIdTest() {
    final Integer userId = 100;
    User user100 = new User(100, "Andres Roa");

    when(iUserRepository.isValidUser(userId)).thenReturn(true);

    when(iUserRepository.getByIdUser(userId)).thenReturn(user100);

    ResponseFollowersListDTO responseFollowersList = userService.getListFollowersById(userId, "name_asc");

    Assertions.assertNotNull(responseFollowersList);
  }

  @Test
  public void getListFollowersByIdDescTest() {

    /** inicio declaracion objectos **/

    final Integer userId = 100;
    final String order = "name_desc";

    List<User> listUsers = new ArrayList<>(Arrays.asList(
        new User(106, "Kevin Molano"),
        new User(101, "Javier Aguayo"),
        new User(103, "David Lozano"),
        new User(105, "Ana Delgado")));

    ResponseFollowersListDTO responseFollowersExpected = new ResponseFollowersListDTO();
    responseFollowersExpected.setUserId(100);
    responseFollowersExpected.setUserName("Andres Roa");
    responseFollowersExpected.setFollowers(listUsers);

    User user100 = new User(100, "Andres Roa");

    List<Integer> listIdsFollowers = new ArrayList<>(Arrays.asList(105, 103, 101, 106));

    /** fin declaracion objectos **/

    when(iUserRepository.isValidUser(userId)).thenReturn(true);

    when(iUserRepository.getByIdUser(userId)).thenReturn(user100);

    when(iFollowerRepository.getFollewersListById(userId)).thenReturn(listIdsFollowers);

    when(iUserRepository.getByIdUser(106)).thenReturn(new User(106, "Kevin Molano"));
    when(iUserRepository.getByIdUser(101)).thenReturn(new User(101, "Javier Aguayo"));
    when(iUserRepository.getByIdUser(103)).thenReturn(new User(103, "David Lozano"));
    when(iUserRepository.getByIdUser(105)).thenReturn(new User(105, "Ana Delgado"));

    ResponseFollowersListDTO responseFollowersList = userService.getListFollowersById(userId, order);

    Assertions.assertEquals(responseFollowersExpected, responseFollowersList);
  }

  @Test
  public void getListFollowersByIdAscTest() {

    /** inicio declaracion objectos **/

    final Integer userId = 100;
    final String order = "name_asc";

    List<User> listUsers = new ArrayList<>(Arrays.asList(
        new User(105, "Ana Delgado"),
        new User(103, "David Lozano"),
        new User(101, "Javier Aguayo"),
        new User(106, "Kevin Molano")
    ));

    ResponseFollowersListDTO responseFollowersExpected = new ResponseFollowersListDTO();
    responseFollowersExpected.setUserId(100);
    responseFollowersExpected.setUserName("Andres Roa");
    responseFollowersExpected.setFollowers(listUsers);

    User user100 = new User(100, "Andres Roa");

    List<Integer> listIdsFollowers = new ArrayList<>(Arrays.asList(105, 103, 101, 106));

    /** fin declaracion objectos **/

    when(iUserRepository.isValidUser(userId)).thenReturn(true);

    when(iUserRepository.getByIdUser(userId)).thenReturn(user100);

    when(iFollowerRepository.getFollewersListById(userId)).thenReturn(listIdsFollowers);

    when(iUserRepository.getByIdUser(106)).thenReturn(new User(106, "Kevin Molano"));
    when(iUserRepository.getByIdUser(101)).thenReturn(new User(101, "Javier Aguayo"));
    when(iUserRepository.getByIdUser(103)).thenReturn(new User(103, "David Lozano"));
    when(iUserRepository.getByIdUser(105)).thenReturn(new User(105, "Ana Delgado"));

    ResponseFollowersListDTO responseFollowersList = userService.getListFollowersById(userId, order);

    Assertions.assertEquals(responseFollowersExpected, responseFollowersList);
  }

  @Test()
  public void getListFollowersByIdExceptionTest() {

    final Integer userId = 100;

    Assertions.assertThrows(OrderNotFoundException.class, () -> {
      userService.getListFollowersById(userId, "");
    });
  }

  @Test
  public void followersCountTest() {
    final Integer userId = 100;
    User user100 = new User(100, "Andres Roa");

    List<Follower> listUsers = new ArrayList<>(Arrays.asList(
        new Follower(100, 105),
        new Follower(100, 103),
        new Follower(100, 101),
        new Follower(100, 106)
    ));

    UserFollowersCountDTO resultExpected = new UserFollowersCountDTO(userId, user100.getUserName(), listUsers.size());

    /** inicio declaracion objectos **/

    when(iUserRepository.isValidUser(userId)).thenReturn(true);

    when(iUserRepository.getByIdUser(userId)).thenReturn(user100);

    when(iFollowerRepository.getFollowersByUserId(userId)).thenReturn(listUsers);

    UserFollowersCountDTO result = userService.followersCount(userId);

    Assertions.assertEquals(resultExpected.getFollowersCount(), result.getFollowersCount());
  }
}
