package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;

import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    void addPromoPost(PromoPostDto postDto);
    PromoPostCountDto getPromoPostCount(Integer userId);
    PromoPostListDto getPromoPostList(Integer userId);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
}
