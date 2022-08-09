package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;


    @Override
    public Boolean followUser(Integer userId, Integer userToFollowId) {

        User user = repository.getUserById(userId);
        User userToFollow = repository.getUserById(userToFollowId);
        Boolean isSeller = userToFollow.getPosts().size()>0;
        Boolean follows = user.getFolloweds().contains(userToFollow);
        Boolean isFollowed = userToFollow.getFollowers().contains(user);

        if (follows || isFollowed || !isSeller){
            System.out.println(user.getFolloweds());
            System.out.println(userToFollow.getFollowers());
            System.out.println(user);
            return false;
        }

        userToFollow.getFollowers().add(user);
        user.getFolloweds().add(userToFollow);
        return true;
    }
}
