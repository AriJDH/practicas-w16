package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.ResponsePostFromFollowedDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowers;

public interface IUserService {

    void addFollower(int idUser, int idUserToFollow);

    UserDto getUserById(int idUser);

    UserFollowersCountDto getUserFollowerCount(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);


    UserFollowers getVendorsFollowedByUser(int userId,String order);

    UserFollowers getAllVendorFollowers(int id,String order);

    ResponsePostFromFollowedDto getPostFromFollowed(int userId, String order);
}
