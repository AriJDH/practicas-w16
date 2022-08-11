package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.Post;

import java.util.List;

public interface IPostRepository {

    void createElement(Post newPost);

    List<Post> searchById(int id);

    //Nico
    List<Post> getPostsByUserIds(List<Integer> userIds);
    List<Post> searchByPostId(int postId);
    void update(int userId,List<Post> newList);
}
