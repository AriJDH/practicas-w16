package com.example.be_java_hisp_w16_g09_Nicoletta.repository;

import com.example.be_java_hisp_w16_g09_Nicoletta.model.Post;

import java.util.List;

public interface IPostRepository {

    void createElement(Post newPost);

    List<Post> searchById(int id);

    //Nico
    List<Post> getPostsByUserIds(List<Integer> userIds);
}
