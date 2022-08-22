package com.bootcamp.SocialMeli2_gonzalez.repository;

import com.bootcamp.SocialMeli2_gonzalez.entiry.Post;

public interface IPostRepository {
    void addPost(Post post);
    Post getPost(int id);
    boolean isPresent(int id);
}
