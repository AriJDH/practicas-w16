package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
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
        Post foundPost = this.findById(post.getId());
        if(foundPost == null) this.posts.add(post);
        else foundPost = post;
        return foundPost;
    }

    @Override
    public List<Post> findByUserId(Integer userID){
        return this.posts.stream()
                .filter(post -> post.getUserId().equals(userID))
                .collect(Collectors.toList());
    }
}
