package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostCountDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostDTO;

public interface IPostService {
    void addPost(PostDTO request, Boolean hasPromo, Double discount);
    void addPromoPost(PromoPostDTO promoPost);
    PostsDTO getLatestPostsByUserId(Integer userId);
    PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order);
    PromoPostCountDTO getPromoPostCountByUserId(Integer userId);
}
