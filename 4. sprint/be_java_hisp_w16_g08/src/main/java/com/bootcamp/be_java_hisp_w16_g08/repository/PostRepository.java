package com.bootcamp.be_java_hisp_w16_g08.repository;

import com.bootcamp.be_java_hisp_w16_g08.entiry.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
