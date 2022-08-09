package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    FollowersDtoResponse getAllFollowers(int id);
    public FollowersCountDTO followerCount(int id);
}
