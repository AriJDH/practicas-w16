package com.example.be_java_hisp_w16_g09_bariani.service;

import com.example.be_java_hisp_w16_g09_bariani.dto.*;

import java.util.List;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);

    FollowersDtoResponse getAllFollowers(int id);

    FollowersCountDTO followerCount(int id);

    void unfollow(int userId, int userIdToUnfollow);

    FollowersDtoResponse orderByName(int id, String order);

    UserFollowedDto orderByNameFollowed(int id, String order);

    UserFollowedDto getUsersFollowedBySellers(int userId);

    List<SimpleUserInfoDto> getAllUsers();

    UserDtoResponse createUser(UserDtoRequest userDtoRequest);
}
