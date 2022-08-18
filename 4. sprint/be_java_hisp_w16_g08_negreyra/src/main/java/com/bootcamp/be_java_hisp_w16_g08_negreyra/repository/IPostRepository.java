package com.bootcamp.be_java_hisp_w16_g08_negreyra.repository;

import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.Post;

public interface IPostRepository {
    void addPost(Post post);
    Post getPost(int id);
    boolean isPresent(int id);
}
