package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;

public interface IPostService {
    MessageDto createPost(PostDto postDto);
    FollowedPostsDto getFollowedPosts(int userId, String order);

    PromoCountDTO getCantPromo(int user_id);

    PromoPostDTO getPromoList(int user_id);
}
