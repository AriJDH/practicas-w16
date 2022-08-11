package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;


public interface IUserService {
    FollowedsDTO getFollowedUsers(Integer userId, String order);

    FollowersDTO getFollowers(Integer id, String order);

    FollowerCountDTO getCountFollowers(Integer id);

    public UserDTO followUser(Integer userId, Integer userToFollowId);

    public UserDTO unfollowUser(Integer userId, Integer userToFollowId);


}
