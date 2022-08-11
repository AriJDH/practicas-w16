package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Discount;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;

public interface IDiscountRepository {
    void save(Post post, Discount discount);
    Discount findByPostId(Integer postId);
}
