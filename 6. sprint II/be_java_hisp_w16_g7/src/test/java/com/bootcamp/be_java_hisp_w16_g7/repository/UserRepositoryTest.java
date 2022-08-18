package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();


    //Test

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