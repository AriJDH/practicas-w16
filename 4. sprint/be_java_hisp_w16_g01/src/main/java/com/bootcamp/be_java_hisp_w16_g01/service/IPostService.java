package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;

public interface IPostService {
    MessageDto createPost(PostDto postDto);
    MessageDto createPromoPost(PromoPostDto postDto);

    FollowedPostsDto getFollowedPosts(int userId, String order);

    PromoPostCountDto getPromoPostsCount(int userId);

    PromoPostListDto getPromoPostsList(int userId);

    MessageDto deletePost(int postId);
}
