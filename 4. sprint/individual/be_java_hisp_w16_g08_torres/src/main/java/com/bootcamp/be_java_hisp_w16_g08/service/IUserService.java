package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.*;

public interface IUserService {

    void addFollower(int idUser, int idUserToFollow);

    UserDto getUserById(int idUser);

    UserFollowersCountDto getUserFollowerCount(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);


    UserFollowedDto getVendorsFollowedByUser(int userId, String order);

    UserFollowers getAllVendorFollowers(int id, String order);

    ResponsePostFromFollowedDto getPostFromFollowed(int userId, String order);

}
