package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;

import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
}
