package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowedListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;

import java.util.List;

public interface IService {
    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);
    FollowersCountResDTO countFollowers(Integer userId);
    List<FollowersListResDTO> listFollowers(Integer userId, String order);
    List<FollowedListResDTO> listFollowed(Integer userId, String order);
    void save(PostReqDTO model);
    List<PostResDTO> listFollowersPosts(Integer userId);
}
