package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.response.UserFollowedDto;
import com.bootcamp.SocialMeli2.dto.response.UserFollowers;
import com.bootcamp.SocialMeli2.dto.response.UserFollowersCountDto;
import com.bootcamp.SocialMeli2.dto.response.ResponsePostFromFollowedDto;

public interface IUserService {

    void addFollower(int idUser, int idUserToFollow);

    UserFollowersCountDto getUserFollowerCount(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);


    UserFollowedDto getVendorsFollowedByUser(int userId, String order);

    UserFollowers getAllVendorFollowers(int id, String order);

    ResponsePostFromFollowedDto getPostFromFollowed(int userId, String order);
}
