package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli2.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
    public List<Post> listPosts();
}
