package com.example.be_java_hisp_w16_g09_bariani.service;

import com.example.be_java_hisp_w16_g09_bariani.dto.PostDto;
import com.example.be_java_hisp_w16_g09_bariani.dto.RecentPostsDTO;

public interface IPostService {
    void createPost(PostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
     RecentPostsDTO orderByDate(int id, String order);
}
