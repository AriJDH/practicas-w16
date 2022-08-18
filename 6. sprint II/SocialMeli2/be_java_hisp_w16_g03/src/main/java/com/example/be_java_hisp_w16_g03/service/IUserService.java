package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;


public interface IUserService {

    User getUser(Integer userId);

    FollowedsDTO getFollowedUsers(Integer userId, String order);

    FollowersDTO getFollowers(Integer id, String order);

    FollowerCountDTO getCountFollowers(Integer id);

    UserDTO followUser(Integer userId, Integer userToFollowId);

    UserDTO unfollowUser(Integer userId, Integer userToFollowId);


}
