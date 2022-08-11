package com.example.socialmeli.service;

import com.example.socialmeli.dto.PostDto;
import com.example.socialmeli.dto.PostDtoWithPromo;
import com.example.socialmeli.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    void addPost(PostDto postDto);
    PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order);
    void addPostWithPromo(PostDtoWithPromo postDtoWithPromo);
    List<Post> getAll();
}
