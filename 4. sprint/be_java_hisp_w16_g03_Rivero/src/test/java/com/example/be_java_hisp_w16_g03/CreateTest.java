package com.example.be_java_hisp_w16_g03;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import com.example.be_java_hisp_w16_g03.repository.UserRepository;
import com.example.be_java_hisp_w16_g03.service.CreatesService;
import com.example.be_java_hisp_w16_g03.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class CreateTest {
    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    public void findAllUsersTest(){

        User user1=new User(1,"emanuel");
        User user2=new User(2,"pedro");

        List<User> listUser= Arrays.asList(user1,user2);


        when(repository.getAllUsers()).thenReturn(listUser);

        List<UserDTO> dataDto=service.getAllUsers();

        assertEquals(listUser.get(1).getUserName(),dataDto.get(1).getUserName());

    }

    @Test
    public  void findByUserIdTest(){

        User user2=new User(2,"pedro");

        //List<User> listUser= Arrays.asList(user1,user2);


        when(repository.getUserById(2)).thenReturn(Optional.of(user2));

        FollowersDTO follo=service.getFollowers(2,null);

        assertEquals(new ArrayList<>(),follo.getFollowers());


    }
    @Test
    public  void findByUserId2Test(){
        List<User> initFollowers = new ArrayList<>();
        User user1=new User(1,"emanuel");
        User user2=new User(2,"pedro");
        initFollowers.add(user1);
        user2.setFollowers(initFollowers);

        //List<User> listUser= Arrays.asList(user1,user2);


        when(repository.getUserById(2)).thenReturn(Optional.of(user2));

        FollowersDTO follo=service.getFollowers(2,null);

        assertEquals(1,follo.getFollowers().size());


    }



}
