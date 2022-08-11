package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.PromoPostCounterDto;
import com.example.be_java_hisp_w16_g09.dto.PromoPostDto;
import com.example.be_java_hisp_w16_g09.dto.RecentPostsDTO;

public interface IPostService {
    void createPost(PostDto postDto);

    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);

    RecentPostsDTO orderByDate(int id, String order);

    void createPromoPost(PromoPostDto promoPostDto);

    PromoPostCounterDto countPromoPosts(int userId);

    void removePost(int postId);

}
