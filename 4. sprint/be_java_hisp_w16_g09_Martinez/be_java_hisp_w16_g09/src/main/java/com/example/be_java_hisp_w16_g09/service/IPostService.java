package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.*;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDto getRecentPostsOfSellersFollowedByUserWith(int anUserId);
     RecentPostsDto orderByDate(int id, String order);

    void createPostWithPromo(PromoPostDto promoPostDto);
     PromoPostCountDto countPromoBySeller(int userId);

    public PromoPostsUserDto getPromoPostsOfUser(int userId);


}
