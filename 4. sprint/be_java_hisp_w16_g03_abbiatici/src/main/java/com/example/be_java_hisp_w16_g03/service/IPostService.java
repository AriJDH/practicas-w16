package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.*;

public interface IPostService {
    void addPost(PostDTO request);
    PostsDTO getLatestPostsByUserId(Integer userId);
    PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order);
    void addPromoPost(PromoPostDTO request);
    PromoPostCountDTO getPromoPostCount(Integer user_id);
    PromoPostsDTO getPromoPostsOrderedByUserId(Integer userId, String order);
}
