package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();


    //Test
    @DisplayName("Verifica que encuentre al usuario")
    @Test
    public void test1(){
        //Arrange
        int id = 1111;

        //Act
        User result = userRepository.findUserById(id);

        //Assert
        assertEquals(id, result.getId());
    }

    @DisplayName("Verifica que no encuentre al usuario (null)")
    @Test
    public void test2(){
        //Arrange
        int id = 101;

        //Act
        User result = userRepository.findUserById(id);

        //Assert
        assertNull(result);
    }

    @Test
    public void existsUserExistingUser() {
        int id = 1111;

        boolean response = userRepository.existsUser(id);

        assertTrue(response);
    }

    @Test
    public void existsUserNonexistentUser() {
        int id = 9999;

        boolean response = userRepository.existsUser(id);

        assertFalse(response);
    }
}