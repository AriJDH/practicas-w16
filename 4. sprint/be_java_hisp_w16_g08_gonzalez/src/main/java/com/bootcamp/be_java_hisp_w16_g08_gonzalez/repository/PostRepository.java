package com.bootcamp.be_java_hisp_w16_g08_gonzalez.repository;

import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.PostPromo;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

import java.util.Map;

@Repository
public class PostRepository implements IPostRepository {
    Map<Integer,Post> postCollection = new HashMap<>();
    Map<Integer,PostPromo> postPromoCollection = new HashMap<>();


    public void addPost(Post post){
        this.postCollection.put(post.getPostId(),post);
    }

    public Post getPost(int id){
        return this.postCollection.get(id);
    }

    public boolean isPresent(int id){
        return this.postCollection.containsKey(id);
    }
    public void addPostPromo(PostPromo postPromo){
        this.postPromoCollection.put(postPromo.getPostId(),postPromo);
    }

    public PostPromo getPostPromo(int id){
        return this.postPromoCollection.get(id);
    }

    public boolean isPresentPromo(int id){
        return this.postPromoCollection.containsKey(id);
    }

}
