package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.repository;

import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.entities.Post;

import java.util.List;

public interface IPostRepository {
     int createPost(Post post);
     List<Post> getPostsByUserId(int userId);

}
