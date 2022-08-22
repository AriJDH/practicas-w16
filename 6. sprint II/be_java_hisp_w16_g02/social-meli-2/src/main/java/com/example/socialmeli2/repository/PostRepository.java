package com.example.socialmeli2.repository;

import com.example.socialmeli2.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IRepository<Post> {
    private Map<Integer, Post> posts = new HashMap<>();
    public PostRepository(){
        this.loadDataBase();
    }

    @Override
    public Post getById(Integer id) {
        return posts.get(id);
    }
    @Override
    public List<Post> getAll() {
        return posts.values().stream().collect(Collectors.toList());
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

    // private
    private void loadDataBase () {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Map<Integer, Post>> typeRef = new TypeReference<>() {
        };

        try {
            file = ResourceUtils.getFile("classpath:posts.json");
            posts = objectMapper
                    .registerModule(new JavaTimeModule())
                    .readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
