package com.example.be_java_hisp_w16_g09_Nicoletta.service;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.*;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.PostDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.RecentPostsDTO;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
     RecentPostsDTO orderByDate(int id, String order);
     void createPostPromo(PostPromoDto promoDto);
     PostPromoResponseDTO calculatePromoCount(int id);
     PostPromoListDTO getPromoOfSeller(int id);
}
