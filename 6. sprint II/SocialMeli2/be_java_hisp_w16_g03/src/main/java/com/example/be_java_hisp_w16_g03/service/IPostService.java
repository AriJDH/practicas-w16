package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;

public interface IPostService {
    void addPost(PostDTO request);
    PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order);
}
