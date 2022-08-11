package com.bootcamp.be_java_hisp_w16_g08_diaz.repository;

import com.bootcamp.be_java_hisp_w16_g08_diaz.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08_diaz.entity.PromoPost;

public interface IPostRepository {
    void addPost(Post post);
    Post getPost(int id);
    boolean isPresent(int id);

    void addPromoPost(PromoPost post);
    Post getPromoPost(int id);
    boolean isPromoPostPresent(int id);


}
