package com.example.be_java_hisp_w16_g09_bariani.service;

import com.example.be_java_hisp_w16_g09_bariani.dto.*;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
    RecentPostsDTO orderByDate(int id, String order);
    void createPromoPost(PromoPostDtoRequest promoPostDtoRequest);
    PromoPostCountDtoResponse countSellerPromoProducts(int anUserId);

    PromoPostListDtoResponse getAllPromoPostOfSeller(int user_id, String order);
}
