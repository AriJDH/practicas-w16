package com.bootcamp.be_java_hisp_w16_g01_rodriguez.repository;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.Post;

import java.util.List;

public interface IPostRepository {
     int createPost(Post post);
     List<Post> getPostsByUserId(int userId);
     int getPromoPostCount(int userId);
     List<Post> getPromoPost(int userId);
}
