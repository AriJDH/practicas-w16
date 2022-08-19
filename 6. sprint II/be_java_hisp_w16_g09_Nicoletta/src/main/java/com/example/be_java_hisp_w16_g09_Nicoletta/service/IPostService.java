package com.example.be_java_hisp_w16_g09_Nicoletta.service;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.PostDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.RecentPostsDTO;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId, String anOrder);
}
