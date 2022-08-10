package com.bootcamp.be_java_hisp_w16_g01.service;
import com.bootcamp.be_java_hisp_w16_g01.dto.*;

public interface IUserService {

    MessageDto addFollower(int idUser, int userIdToFollow);

    UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow);

    UserFollowerDTO getFollowers(int userId, String order);

    UserFollowedDTO getFollowed(int userId, String order);

    FollowersCountDTO getCantFollowers(int userId);

}
