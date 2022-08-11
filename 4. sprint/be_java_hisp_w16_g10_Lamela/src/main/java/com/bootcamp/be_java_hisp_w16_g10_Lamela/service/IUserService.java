package com.bootcamp.be_java_hisp_w16_g10_Lamela.service;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.User;

import java.util.List;

public interface IUserService {
    User findById(Integer id);

    List<UserResDTO> findAll();

    void follow(Integer userId, Integer userIdToFollow);

    void unfollow(Integer userId, Integer userIdToUnfollow);

    FollowersCountResDTO countFollowers(Integer userId);

    FollowersListResDTO listFollowers(Integer userId, String order);

    FollowedListResDTO listFollowed(Integer userId, String order);
}
