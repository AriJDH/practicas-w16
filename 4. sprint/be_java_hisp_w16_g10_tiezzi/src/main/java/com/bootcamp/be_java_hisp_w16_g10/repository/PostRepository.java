package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts;
    private Integer id;

    public PostRepository() {
        this.posts = new ArrayList<>();
        this.id = 1;
    }

    @Override
    public List<Post> findAll(){
        return this.posts;
    }

    @Override
    public Post findById(Integer id){
        return this.posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post save(Post post){
        post.setId(this.id++);
        this.posts.add(post);
        return post;
    }

    @Override
    public List<Post> findByUserId(Integer userID){
        return this.posts.stream()
                .filter(post -> post.getUserId().equals(userID))
                .collect(Collectors.toList());
    }
}
