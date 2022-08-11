package com.bootcamp.be_java_hisp_w16_g01.service;
import com.bootcamp.be_java_hisp_w16_g01.dto.*;

public interface IUserService {

    MessageDto addFollower(int idUser, int userIdToFollow);

    UserUnfollowDto unfollowUser(int userId, int userIdToUnfollow);

    UserFollowerDto getFollowers(int userId, String order);

    UserFollowedDto getFollowed(int userId, String order);

    FollowersCountDto getCantFollowers(int userId);

}
