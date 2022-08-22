package com.example.socialmeli.service;

import com.example.socialmeli.dto.UserFollowedListDto;
import com.example.socialmeli.dto.UserFollowersListDto;
import com.example.socialmeli.dto.UserFollowersCountDto;
import com.example.socialmeli.model.User;

import java.util.Optional;


public interface IUserService {

    void add(User user);
    User getById(Integer userId);
    void addFollower(Integer userId, Integer userIdFollowed);
    void removeFollower(Integer userId, Integer userIdToUnfollow);
    UserFollowersCountDto getFollowersCountByUserId(Integer userId);
    UserFollowersListDto getFollowersListByUserId(Integer userId, Optional<String> order);
    UserFollowedListDto getFollowedListByUserId(Integer userId, Optional<String> order);
    void initUserData();

}
