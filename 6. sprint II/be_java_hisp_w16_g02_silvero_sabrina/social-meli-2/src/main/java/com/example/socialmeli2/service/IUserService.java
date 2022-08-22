package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.UserFollowedListDto;
import com.example.socialmeli2.dto.UserFollowersListDto;
import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.model.User;

import java.util.Optional;


public interface IUserService {

    User getById(Integer userId);
    void addFollower(Integer userId, Integer userIdFollowed);
    void removeFollower(Integer userId, Integer userIdToUnfollow);
    UserFollowersCountDto getFollowersCountByUserId(Integer userId);
    UserFollowersListDto getFollowersListByUserId(Integer userId, Optional<String> order);
    UserFollowedListDto getFollowedListByUserId(Integer userId, Optional<String> order);

}
