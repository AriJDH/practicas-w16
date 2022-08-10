package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;

import java.util.List;

public interface IUserService {
    FollowersDTO getFollowers(Integer id);

    FollowerCountDTO getCountFollowers(Integer id);

    public UserDTO followUser(Integer userId, Integer userToFollowId);

    public UserDTO unfollowUser(Integer userId, Integer userToFollowId);

}
