package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;

import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
    void addPostPromo(PostPromoDto postPromo);
    PostPromoCountDto getPostPromoCount(Integer userId);
    PostPromoListDto getPostPromoList(Integer userId);
}
