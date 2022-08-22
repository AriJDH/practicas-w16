package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.model.PostUS10;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    void addPromoPost(PostUS10DTO postUS10DTO);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
    List<PostUS10> listarPostsUS10();
    CountProductsDTO productCountByUser(Integer userId);
    ListPostsDTO listarPromoPostsById(Integer userId);
}
