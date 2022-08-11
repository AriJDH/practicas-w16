package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.Post;

import java.util.List;

public interface IPostRepository {
     int createPost(Post post);
     List<Post> getPostsByUserId(int userId);
     List<Post> getPromoPostsByUserId(int userId);

     Post getPost(int postId);

     void deletePost(int postId);

}
