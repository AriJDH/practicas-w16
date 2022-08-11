package com.example.Sprint1.service;

import com.example.Sprint1.dto.FollowersCountDTO;
import com.example.Sprint1.dto.FollowersDtoResponse;
import com.example.Sprint1.dto.UserFollowedDto;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    FollowersDtoResponse getAllFollowers(int id);
     FollowersCountDTO followerCount(int id);
    void unfollow(int userId, int userIdToUfollow);
     FollowersDtoResponse orderByName(int id, String order);
    UserFollowedDto orderByNameFollowed(int id, String order);
     UserFollowedDto getUsersFollowedBySellers(int userId);
}
