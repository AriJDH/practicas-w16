package com.bootcamp.be_java_hisp_w16_g01_Morales.service;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.PostDto;

public interface IPostService {
    MessageDto createPost(PostDto postDto);
    FollowedPostsDto getFollowedPosts(int userId, String order);
}
