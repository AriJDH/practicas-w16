package com.bootcamp.be_java_hisp_w16_g08_gonzalez.repository;

import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.PostPromo;

public interface IPostRepository {
    void addPost(Post post);
    Post getPost(int id);
    boolean isPresent(int id);
    void addPostPromo(PostPromo postPromo);
    PostPromo getPostPromo(int id);
    boolean isPresentPromo(int id);
}
