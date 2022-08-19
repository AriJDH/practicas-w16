package com.bootcamp.be_java_hisp_w16_g01.repositories;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    UserRepository repository;

    @BeforeEach
    public void emptyRepo(){
        this.repository = new UserRepository();
    }

    @Test
    public void getUserOk(){
        //arrange
        User user4= new User(4, "Usuario4", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());

        // act
        User found = repository.getUser(user4.getUserId());

        // assert
        Assertions.assertEquals(found, user4);
    }

    @Test
    public void getUserInvalid(){
        User user10= new User(10, "Usuario10", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());

        // assert
        Assertions.assertNull(repository.getUser(user10.getUserId()));
    }
}
