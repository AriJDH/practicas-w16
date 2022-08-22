package com.bootcamp.be_java_hisp_w16_g04.Repository;

import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.UserRepository;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  UserRepository UserRepository;

  @Autowired
  IUserRepository userRepository;

  @Test
  public void iUserValidNull() {

    List<User> users = TestUtilsGenerator.createListUsers();
    UserRepository.setUsers(users);

    Integer userId = 101;
    Assertions.assertFalse(userRepository.isValidUser(userId));
  }

  @Test
  public void iUserValidUser() {
    List<User> users = TestUtilsGenerator.createListUsers();
    UserRepository.setUsers(users);

    Integer userId = 103;
    Assertions.assertTrue(userRepository.isValidUser(userId));
  }

  @Test
  public void getByIdUserTest() {
    List<User> users = TestUtilsGenerator.createListUsers();
    UserRepository.setUsers(users);

    User andres = new User(103, "David Lozano");

    User result = userRepository.getByIdUser(103);

    Assertions.assertEquals(andres, result);
  }

}
