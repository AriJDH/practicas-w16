package com.example.Sprint1.service;

import com.example.Sprint1.dto.*;
import com.example.Sprint1.dto.PostDto;
import com.example.Sprint1.dto.RecentPostsDTO;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
     RecentPostsDTO orderByDate(int id, String order);
     void createPostPromo(PostPromoDto promoDto);
     PostPromoResponseDTO calculatePromoCount(int id);
     PostPromoListDTO getPromoOfSeller(int id);
}
