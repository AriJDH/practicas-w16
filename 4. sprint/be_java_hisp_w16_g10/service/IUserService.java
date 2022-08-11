package com.bootcamp.be_java_hisp_w16_g10.service;

import java.util.List;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowedListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.UserResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;

public interface IUserService {
   User findById(Integer id);

   List<UserResDTO> findAll();

   void follow(Integer userId, Integer userIdToFollow);

   void unfollow(Integer userId, Integer userIdToUnfollow);

   FollowersCountResDTO countFollowers(Integer userId);

   FollowersListResDTO listFollowers(Integer userId, String order);

   FollowedListResDTO listFollowed(Integer userId, String order);
}
