package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductCountDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostDTO;

public interface IPostService {
    void addPost(PostDTO request);

    PostsDTO getLatestPostsByUserId(Integer userId);

    PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order);

    PromoPostDTO addPromoPost(PromoPostDTO request);

    ProductCountDTO getProductCountByUserId(Integer userId);
}
