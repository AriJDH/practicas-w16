package com.bootcamp.be_java_hisp_w16_g08_CONDORI.repository;

import com.bootcamp.be_java_hisp_w16_g08_CONDORI.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08_CONDORI.entiry.PostPromotion;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

import java.util.Map;

@Repository
public class PostRepository implements IPostRepository {
    Map<Integer,Post> postCollection = new HashMap<>();
    Map<Integer,PostPromotion> postPromoCollection = new HashMap<>();


    public void addPost(Post post){
        this.postCollection.put(post.getPostId(),post);
    }

    @Override
    public void addPromoPost(PostPromotion post) { this.postPromoCollection.put(post.getPostId(),post); }

    public Post getPost(int id){
        return this.postCollection.get(id);
    }

    public boolean isPresent(int id){
        return this.postCollection.containsKey(id);
    }


}
