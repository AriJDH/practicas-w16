package com.example.socialmeli.service;

import com.example.socialmeli.dto.UserDto;
import com.example.socialmeli.dto.UserFollowedListDto;
import com.example.socialmeli.dto.UserFollowersListDto;
import com.example.socialmeli.dto.UserFollowersCountDto;

import java.util.Map;
import java.util.Optional;


public interface IUserService {

    void addFollower(Integer userId, Integer userIdFollowed);
    void removeFollower(Integer userId, Integer userIdToUnfollow);
    UserFollowersCountDto getFollowersCountByUserId(Integer userId);
    UserFollowersListDto getFollowersListByUserId(Integer userId, Optional<String> order);
    UserFollowedListDto getFollowedListByUserId(Integer userId, Optional<String> order);
    void initUserData();
}
