package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostUS10;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IRepository<Post> {
    private Map<Integer, Post> posts = new HashMap<>();
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
}
