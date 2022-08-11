package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.*;

public interface IPostService {
    void addPost(PostDTO request);

    PostHasPromoCountDTO countPostHasPromoDTO(Integer id);

    PostHasPromoDTO addPostHasPromo(PostHasPromoDTO postHasPromoDTO);

    PostsDTO getLatestPostsByUserId(Integer userId);

    PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order);

    PostsHasPromoDTO getPostWithPromoById(Integer id,String order);
}
