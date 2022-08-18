package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.UserFollowedDto;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    FollowersDtoResponse getAllFollowers(int id, String order);
     FollowersCountDTO followerCount(int id);
    void unfollow(int userId, int userIdToUfollow);
     UserFollowedDto getUsersFollowedBySellers(int userId, String order);
}
