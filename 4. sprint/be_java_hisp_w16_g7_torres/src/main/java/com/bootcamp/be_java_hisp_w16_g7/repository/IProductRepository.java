package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import java.time.LocalDate;
import java.util.List;

public interface IProductRepository {
    List<Integer> getPostsId(List<Post> posts);
    int getPromoPostsCount(List<Post> posts);
    LocalDate getOldestPostDate(List<Post> posts);

    LocalDate getNewestPostDate(List<Post> posts);

    double getPostsTotalValue(List<Post> posts);
    Post getHighestPricePost(List<Post> posts);
}
