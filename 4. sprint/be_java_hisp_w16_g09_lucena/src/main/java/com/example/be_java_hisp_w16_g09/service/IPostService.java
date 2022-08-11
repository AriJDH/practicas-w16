package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.*;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
     RecentPostsDTO orderByDate(int id, String order);

    void createPostPromo(PostPromoDto postPromoDto);

    PromoPostCountDto getTotalPromoPost(int userId);

    PromoPostSellerListDto getListPromoPostSeller(int user_id);
}
