package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.service;

import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.request.PostDto;

public interface IPostService {
    MessageDto createPost(PostDto postDto);
    FollowedPostsDto getFollowedPosts(int userId, String order);
}
