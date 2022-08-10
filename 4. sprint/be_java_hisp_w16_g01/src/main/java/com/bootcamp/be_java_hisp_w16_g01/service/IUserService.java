package com.bootcamp.be_java_hisp_w16_g01.service;
import com.bootcamp.be_java_hisp_w16_g01.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDTO;

public interface IUserService {

    void addFollower(int idUser, int userIdToFollow);

    UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow);

    UserFollowerDTO getFollowers(int userId);
    UserFollowedDTO getFollowed(int userId);

    FollowersCountDTO getCantFollowers(int userId);

}
