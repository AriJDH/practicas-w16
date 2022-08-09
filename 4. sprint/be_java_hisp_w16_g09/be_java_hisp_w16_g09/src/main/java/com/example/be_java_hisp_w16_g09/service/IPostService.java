package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.NewPostDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;

import com.example.be_java_hisp_w16_g09.dto.RecentPostsDTO;

import java.util.List;

public interface IPostService {
    void createPost(NewPostDto postDto);
    RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId);
}
