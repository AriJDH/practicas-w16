package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public Boolean followUser(Integer userId, Integer userToFollowId) {

        User user = repository.getUserById(userId);
        User userToFollow = repository.getUserById(userToFollowId);
        Boolean isSeller = userToFollow.validatePosts().size() > 0;
        Boolean follows = user.validateFolloweds().contains(userToFollow);
        Boolean isFollowed = userToFollow.validateFollowers().contains(user);

        if (follows || isFollowed || !isSeller) {
            return false;
        }

        userToFollow.getFollowers().add(user);
        user.getFolloweds().add(userToFollow);
        return true;
    }

    public Boolean unfollowUser(Integer userId, Integer userToFollowId) {
        User user = repository.getUserById(userId);
        User userToUnfollow = repository.getUserById(userToFollowId);
        
        Boolean unfollowDone = user.validateFolloweds().remove(userToUnfollow);
        Boolean followerRemove = userToUnfollow.validateFollowers().remove(user);

        return unfollowDone && followerRemove;
    }
}
