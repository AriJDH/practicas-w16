package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;

import java.util.List;

public interface IService {
    List<UserResDTO> findAll();
    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);
    FollowersCountResDTO countFollowers(Integer userId);
    PostPromoCountResDTO countPosts(Integer userId);
    FollowersListResDTO listFollowers(Integer userId, String order);
    FollowedListResDTO listFollowed(Integer userId, String order);
    void save(PostReqDTO model);
    void savePromo(PostReqDTO model);
    List<PostResDTO> listFollowersPosts(Integer userId, String order);
    List<PostPromoResDTO> listPosts(Integer userId);
}
