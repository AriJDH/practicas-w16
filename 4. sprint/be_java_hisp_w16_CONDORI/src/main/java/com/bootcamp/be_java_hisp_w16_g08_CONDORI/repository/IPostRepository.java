package com.bootcamp.be_java_hisp_w16_g08_CONDORI.repository;

import com.bootcamp.be_java_hisp_w16_g08_CONDORI.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08_CONDORI.entiry.PostPromotion;

public interface IPostRepository {
    void addPost(Post post);

    void addPromoPost(PostPromotion post);
    Post getPost(int id);
    boolean isPresent(int id);
}
