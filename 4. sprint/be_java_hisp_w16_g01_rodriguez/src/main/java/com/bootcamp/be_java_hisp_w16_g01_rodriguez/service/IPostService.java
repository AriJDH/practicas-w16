package com.bootcamp.be_java_hisp_w16_g01_rodriguez.service;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.*;

public interface IPostService {
    MessageDTO createPost(PostDTO postDto);
    MessageDTO createPromoPost(PromoPostDTO postDto);
    FollowedPostsDTO getFollowedPosts(int userId, String order);
    PromoPostCountDTO getPromoPostCount(int userId);
    UserPromoPostsDTO getUserPromoPosts(int userId);
}
