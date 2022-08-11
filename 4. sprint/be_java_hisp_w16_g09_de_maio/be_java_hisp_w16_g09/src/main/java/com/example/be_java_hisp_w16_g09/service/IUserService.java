package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.dto.UserFollowedDto;
import com.example.be_java_hisp_w16_g09.model.User;

import java.util.List;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    FollowersDtoResponse getAllFollowers(int id);
     FollowersCountDTO followerCount(int id);
    void unfollow(int userId, int userIdToUfollow);
     FollowersDtoResponse orderByName(int id, String order);
    UserFollowedDto orderByNameFollowed(int id, String order);
     UserFollowedDto getUsersFollowedBySellers(int userId);

    User getValidatedUser(int userId);

    List<SimpleUserDto> getRegisteredUsersConsidering(String order);
}
