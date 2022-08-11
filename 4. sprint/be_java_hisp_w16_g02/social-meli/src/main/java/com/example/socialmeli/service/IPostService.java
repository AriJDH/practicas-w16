package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.PostListLastTwoWeeksDto;

import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
}
