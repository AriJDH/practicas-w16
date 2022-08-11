package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.PromoPost;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();

    Post findById(Integer id);

    Post save(Post post);

    List<Post> findByUserId(Integer userID);

    List<PromoPost> findPromosByUserId(Integer userId);
}
