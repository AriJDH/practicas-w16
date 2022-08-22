package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository userRepository;

    @BeforeEach
    public void init() {
        userRepository = new UserRepository();
        List<User> users = Factory.generateUserList(5, 100);
        users.forEach(user -> this.userRepository.save(user));
    }

    @Test
    void givenAValidIdShouldReturnCorrectUser_whenCalled() {
        User user = this.userRepository.findById(1);
        assertNotNull(user);
        assertInstanceOf(User.class, user);
        assertEquals(1, user.getId());
    }

    @Test
    void repositoryShouldReturnAllUsersAsList_whenCalled() {
        List<User> users = this.userRepository.findAll();
        assertNotNull(users);
        assertInstanceOf(List.class, users);
        assertInstanceOf(User.class, users.get(1));
        assertEquals(5 + 5, users.size());
    }

    @Test
    void repositoryShouldSaveAnUser_whenGivenAnUser() {
        User user = Factory.generateUser(555, "TestUser",
                null, null);
        this.userRepository.save(user);

        User storedUser = this.userRepository.findById(555);
        assertInstanceOf(User.class, storedUser);
        assertEquals(user, storedUser);
    }

    @Test
    void repositoryShouldUpdateUser_whenGivenUserId() {
        User newUser = Factory.generateUser(3, "TestUser",
                null, null);
        User oldUser = this.userRepository.findById(3);
        this.userRepository.update(newUser);
        User storedUser = this.userRepository.findById(3);

        assertInstanceOf(User.class, storedUser);
        assertNotEquals(oldUser, storedUser);
        assertEquals(newUser, storedUser);
        assertEquals(3, storedUser.getId());
        assertEquals("TestUser", storedUser.getUserName());
    }
}