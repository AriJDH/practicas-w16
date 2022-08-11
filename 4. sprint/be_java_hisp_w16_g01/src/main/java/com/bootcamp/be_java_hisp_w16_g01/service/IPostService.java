package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.PostDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.ResponsePromoPostDTO;

public interface IPostService {
    MessageDto createPost(PostDto postDto);

    FollowedPostsDto getFollowedPosts(int userId, String order);

    ResponsePromoPostDTO getPromoPostsQty(int userId);
}
