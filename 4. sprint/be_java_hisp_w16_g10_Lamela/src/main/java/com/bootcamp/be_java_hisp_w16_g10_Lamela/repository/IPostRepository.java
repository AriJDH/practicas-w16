package com.bootcamp.be_java_hisp_w16_g10_Lamela.repository;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Discount;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Post;

import java.util.List;
import java.util.Map;

public interface IPostRepository {
    List<Post> findAll();

    Post findById(Integer id);

    Post save(Post post);

    List<Post> findByUserId(Integer userID);
    Discount savePromo(Integer postId, Discount discount);
    List<Post> findByUserIdWithPromo(Integer userID);
    Map<Integer, Discount> getDiscountsByPosts(List<Post> posts);
}
