package com.bootcamp.be_java_hisp_w16_g10_Lamela.repository;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Discount;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Post;

public interface IDiscountRepository {
    void save(Post post, Discount discount);
    Discount findByPostId(Integer postId);
}
