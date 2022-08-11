package com.example.be_java_hisp_w16_g09_Nicoletta.service;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.UserFollowedDto;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    FollowersDtoResponse getAllFollowers(int id);
     FollowersCountDTO followerCount(int id);
    void unfollow(int userId, int userIdToUfollow);
     FollowersDtoResponse orderByName(int id, String order);
    UserFollowedDto orderByNameFollowed(int id, String order);
     UserFollowedDto getUsersFollowedBySellers(int userId);
}
