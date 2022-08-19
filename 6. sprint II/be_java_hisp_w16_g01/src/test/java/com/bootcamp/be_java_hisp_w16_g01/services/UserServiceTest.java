package com.bootcamp.be_java_hisp_w16_g01.services;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void nameAscOrderFollowersOk(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowers(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nameDescOrderFollowersOk(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowers(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void invalidOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        assertThrows(BadRequestException.class , () -> userService.getFollowers(4, "id_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nullOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), null);

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        followers.forEach(follower -> {
            assertTrue(response.getFollowers().stream().anyMatch(u -> u.getUserId() == follower.getUserId() &&
                    u.getUserName().equals(follower.getUserName())));
        });
    }
    @Test
    public void invalidUserFollowers(){
        User user = new User(44, "user 44");

        //arrange
        when(userRepository.getUser(user.getUserId())).thenReturn(null);

        // act & assert
        assertThrows(BadRequestException.class , () -> userService.getFollowers(user.getUserId(), "name_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void verifyNameAscOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowers().size() ; i++){
            assertEquals(response.getFollowers().get(i).getUserName(), followers.get(i).getUserName());
            assertEquals(response.getFollowers().get(i).getUserId(), followers.get(i).getUserId());
        }

    }
    @Test
    public void verifyNameDescOrderFollowers(){
        List<User> followers = new ArrayList<>();
        followers.add(new User(2, "sofia"));
        followers.add(new User(1, "juan"));
        followers.add(new User(3, "alberto"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowerDTO response = userService.getFollowers(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowers().size() ; i++){
            assertEquals(response.getFollowers().get(i).getUserName(), followers.get(i).getUserName());
            assertEquals(response.getFollowers().get(i).getUserId(), followers.get(i).getUserId());
        }
    }

    @Test
    public void nameAscOrderFollowedOk(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowed(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nameDescOrderFollowedOk(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        userService.getFollowed(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void invalidOrderFollowed(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        assertThrows(BadRequestException.class , () -> userService.getFollowed(4, "id_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void nullOrderFollowed(){
        List<User> followed= new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), null);

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        followed.forEach(follow -> {
            assertTrue(response.getFollowed().stream().anyMatch(u -> u.getUserId() == follow.getUserId() &&
                    u.getUserName().equals(follow.getUserName())));
        });
    }

    @Test
    public void invalidUserFollowed(){
        User user = new User(44, "user 44");

        //arrange
        when(userRepository.getUser(user.getUserId())).thenReturn(null);

        // act & assert
        assertThrows(BadRequestException.class , () -> userService.getFollowed(user.getUserId(), "name_asc"));
        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
    }

    @Test
    public void verifyNameAscOrderFollowed(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), "name_asc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowed().size() ; i++){
            assertEquals(response.getFollowed().get(i).getUserName(), followed.get(i).getUserName());
            assertEquals(response.getFollowed().get(i).getUserId(), followed.get(i).getUserId());
        }
    }
    @Test
    public void verifyNameDescOrderFollowed(){
        List<User> followed = new ArrayList<>();
        followed.add(new User(2, "sofia"));
        followed.add(new User(1, "juan"));
        followed.add(new User(3, "alberto"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);
        when(userRepository.getUser(user.getUserId())).thenReturn(user);

        UserFollowedDTO response = userService.getFollowed(user.getUserId(), "name_desc");

        verify(userRepository, atLeastOnce()).getUser(user.getUserId());
        for (int i = 0 ; i< response.getFollowed().size() ; i++){
            assertEquals(response.getFollowed().get(i).getUserName(), followed.get(i).getUserName());
            assertEquals(response.getFollowed().get(i).getUserId(), followed.get(i).getUserId());
        }
    }
}
