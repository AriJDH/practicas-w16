package com.example.Sprint1.repository;

import com.example.Sprint1.model.Post;

import java.util.List;

public interface IPostRepository {

    void createElement(Post newPost);

    List<Post> searchById(int id);

    //Nico
    List<Post> getPostsByUserIds(List<Integer> userIds);
}
