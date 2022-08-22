package com.example.socialmeli2.repository;

import com.example.socialmeli2.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IRepository<Post> {
    private final Map<Integer, Post> posts = new HashMap<>();

    @Override
    public Post getById(Integer id) {
        return posts.get(id);
    }
    @Override
    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }
    @Override
    public void update(Post post) {
        posts.put(post.getPostId(),post);
    }
    @Override
    public Integer add(Post post) {
        Integer id = posts.size() + 1;
        post.setPostId(id);
        posts.put(id,post);
        return id;
    }
}
