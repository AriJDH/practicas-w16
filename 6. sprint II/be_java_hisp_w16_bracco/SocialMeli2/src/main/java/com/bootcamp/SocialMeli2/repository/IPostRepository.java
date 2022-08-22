package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entity.Post;

public interface IPostRepository {
    void addPost(Post post);
    Post getPost(int id);
    boolean isPresent(int id);
}
