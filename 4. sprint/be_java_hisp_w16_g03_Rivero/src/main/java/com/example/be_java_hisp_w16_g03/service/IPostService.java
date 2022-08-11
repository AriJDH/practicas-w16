package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostHasPromoCountDTO;
import com.example.be_java_hisp_w16_g03.dto.PostHasPromoDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;

public interface IPostService {
    void addPost(PostDTO request);

    PostHasPromoCountDTO countPostHasPromoDTO(Integer id);

    PostHasPromoDTO addPostHasPromo(PostHasPromoDTO postHasPromoDTO);

    PostsDTO getLatestPostsByUserId(Integer userId);

    PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order);
}
