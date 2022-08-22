package com.bootcamp.SocialMeli2_gonzalez.service;

import com.bootcamp.SocialMeli2_gonzalez.dto.response.UserDto;
import com.bootcamp.SocialMeli2_gonzalez.dto.response.UserFollowedDto;
import com.bootcamp.SocialMeli2_gonzalez.dto.response.UserFollowers;
import com.bootcamp.SocialMeli2_gonzalez.dto.response.UserFollowersCountDto;
import com.bootcamp.SocialMeli2_gonzalez.dto.response.ResponsePostFromFollowedDto;

public interface IUserService {

    void addFollower(int idUser, int idUserToFollow);

    UserDto getUserById(int idUser);

    UserFollowersCountDto getUserFollowerCount(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);


    UserFollowedDto getVendorsFollowedByUser(int userId, String order);

    UserFollowers getAllVendorFollowers(int id, String order);

    ResponsePostFromFollowedDto getPostFromFollowed(int userId, String order);
}
