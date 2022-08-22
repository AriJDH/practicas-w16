package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.service;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.*;

public interface IUserService {

    MessageDto addFollower(int idUser, int userIdToFollow);


    UserUnfollowDTO unfollowUser(Integer userId, Integer userIdToUnfollow);

    UserFollowerDTO getFollowers(Integer userId, String order);

    UserFollowedDTO getFollowed(Integer userId, String order);

    FollowersCountDTO getCantFollowers(int userId);

}
