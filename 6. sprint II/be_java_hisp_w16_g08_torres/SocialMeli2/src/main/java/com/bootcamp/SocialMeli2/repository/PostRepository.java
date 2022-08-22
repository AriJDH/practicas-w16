package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entiry.Post;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

import java.util.Map;

@Repository
public class PostRepository implements IPostRepository {
    Map<Integer,Post> postCollection = new HashMap<>();


    public void addPost(Post post){
        this.postCollection.put(post.getPostId(),post);
    }

    public Post getPost(int id){
        return this.postCollection.get(id);
    }

    public boolean isPresent(int id){
        return this.postCollection.containsKey(id);
    }


}
