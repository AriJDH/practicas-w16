package com.example.socialmeli.repository;

import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostUS10;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostUS10Repository {
    private Map<Integer, PostUS10> postsUS10 = new HashMap<>();

    public Integer addPromoPost(PostUS10 postUS10) {
        Integer id = postsUS10.size() + 1;
        postUS10.setPostId(id);
        postsUS10.put(id,postUS10);
        return id;
    }

    public List<PostUS10> getAll() {
        return postsUS10.values().stream().collect(Collectors.toList());
    }
}
