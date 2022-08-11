package com.bootcamp.be_java_hisp_w16_g08.repository;

import com.bootcamp.be_java_hisp_w16_g08.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08.entity.PromoPost;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

import java.util.Map;

@Repository
public class PostRepository implements IPostRepository {
    Map<Integer,Post> postCollection = new HashMap<>();
    Map<Integer, PromoPost> promoPostCollection = new HashMap<>();

    public void addPost(Post post){
        this.postCollection.put(post.getPostId(),post);
    }

    public Post getPost(int id){
        return this.postCollection.get(id);
    }

    public boolean isPresent(int id){
        return this.postCollection.containsKey(id);
    }

    public void addPromoPost(PromoPost promoPost){
        this.promoPostCollection.put(promoPost.getPostId(),promoPost);
    }

    public PromoPost getPromoPost(int id){
        return this.promoPostCollection.get(id);
    }

    public boolean isPromoPostPresent(int id){
        return this.promoPostCollection.containsKey(id);
    }
}
