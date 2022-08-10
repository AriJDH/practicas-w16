package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;

public interface IUserService {

     void addFollower(int idUser, int idUserToFollow);

     UserDto getUserById(int idUser);

     UserFollowersCountDto getUserFollowerCount(int userId);

     void unfollowUser(int userId, int userIdToUnfollow);
}
