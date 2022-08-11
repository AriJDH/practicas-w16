package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Discount;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DiscountRepository implements IDiscountRepository {
    private Map<Integer, Discount> discounts;
    public DiscountRepository() {
        this.discounts = new HashMap<>();
    }
    public void save(Post post, Discount discount) {
        this.discounts.put(post.getId(), discount);
    }
    public Discount findByPostId(Integer postId) {
        return this.discounts.get(postId);
    }
}
