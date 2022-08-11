package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.*;

import java.util.List;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
     RecentPostsDTO orderByDate(int id, String order);

    void createPromotedPost(PromotedPostDTO promotedPostDTO);

    PromotedPostsCountDTO amountOfPromoPostsPublishedByUserWith(int userId);

    PromotedPostsOfUserDTO getPromotedPostsOfUser(int anUserId);
}
