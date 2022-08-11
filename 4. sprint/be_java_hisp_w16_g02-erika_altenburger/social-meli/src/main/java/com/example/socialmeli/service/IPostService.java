package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.model.User;

import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    void addPromoPost(PromoPostDto postPromoDto);
    PromoPostCountDto getPromoPostCount(Integer userId);
    UserListPromoPostDto getListUserPromoPost(Integer userId);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
}
