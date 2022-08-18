package com.bootcamp.be_java_hisp_w16_g10_Lamela.repository;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Discount;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts;
    private Integer id;
    @Autowired
    private DiscountRepository discountRepository;

    public PostRepository() {
        this.posts = new ArrayList<>();
        this.id = 1;
    }

    @Override
    public List<Post> findAll(){
        return this.posts;
    }

    @Override
    public Post findById(Integer id){
        return this.posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post save(Post post){
        post.setId(this.id++);
        this.posts.add(post);
        return post;
    }
    @Override
    public Discount savePromo(Integer postId, Discount discount) {
        Post post = this.findById(postId);
        if(post == null) throw new BadRequestException("The post does not exists");
        this.discountRepository.save(post, discount);
        return discount;
    }
    @Override
    public List<Post> findByUserId(Integer userID){
        return this.posts.stream()
                .filter(post -> post.getUserId().equals(userID))
                .collect(Collectors.toList());
    }
    @Override
    public List<Post> findByUserIdWithPromo(Integer userID) {
        return this.posts.stream()
                .filter(post -> post.getUserId().equals(userID) &&
                    this.discountRepository.findByPostId(post.getId()) != null)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, Discount> getDiscountsByPosts(List<Post> posts) {
        Map<Integer, Discount> discounts = new HashMap<>();
            posts
                .stream()
                .forEach(post -> discounts.put(post.getId(), this.discountRepository.findByPostId(post.getId())));
        return discounts;
    }
}
