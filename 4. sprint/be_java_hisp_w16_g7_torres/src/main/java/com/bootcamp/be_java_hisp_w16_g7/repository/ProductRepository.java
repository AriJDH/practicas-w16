package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public List<Integer> getPostsId(List<Post> posts){
        return posts.stream().map(Post::getPostId).collect(Collectors.toList());
    }
    @Override
    public int getPromoPostsCount(List<Post> posts){
        return (int) posts.stream().filter(Post::isHasPromo).count();
    }
    @Override
    public double getPostsTotalValue(List<Post> posts){
        return posts.stream().mapToDouble(Post::getPrice).sum();
    }

    @Override
    public Post getHighestPricePost(List<Post> posts) {
        return posts.stream().max(Comparator.comparing(Post::getPrice)).get();
    }

    @Override
    public LocalDate getOldestPostDate(List<Post> posts){
        Post oldestPost = posts.stream().min(Comparator.comparing(Post::getCreationDate)).orElse(null);
        if(oldestPost != null) return oldestPost.getCreationDate();
        return null;
    }
    @Override
    public LocalDate getNewestPostDate(List<Post> posts){
        Post newestPost = posts.stream().max(Comparator.comparing(Post::getCreationDate)).orElse(null);
        if(newestPost != null) return newestPost.getCreationDate();
        return null;
    }
}
