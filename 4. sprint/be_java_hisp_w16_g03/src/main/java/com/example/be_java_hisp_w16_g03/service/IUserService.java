package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;

import java.util.List;

public interface IUserService {
    FollowedsDTO getFollowedUsers(Integer userId, String order);
    FollowersDTO getFollowers(Integer id);
    FollowerCountDTO getCountFollowers(Integer id);
}
