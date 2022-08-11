package com.example.be_java_hisp_w16_g03.entity;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String userName;
    private List<User> followers;
    private List<User> followeds;
    private List<Post> posts;

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public List<User> getterFollowers() {
        if (this.followers == null) {
            this.followers = new ArrayList<>();
        }
        return this.followers;
    }

    public List<User> getterFolloweds() {
        if (this.followeds == null) {
            this.followeds = new ArrayList<>();
        }
        return this.followeds;
    }

    public List<Post> getterPosts() {
        if (this.posts == null) {
            this.posts = new ArrayList<>();
        }
        return this.posts;
    }

    public void addPostWithOutPromo(PostDTO request) {

        Post postWithOutPromo = new PostWithOutPromo(request.getUserId(), request.getDate(), request.getPrice(), Product.builder()
                .productName(request.getProduct().getProductName())
                .productId(request.getProduct().getProductId())
                .notes(request.getProduct().getNotes())
                .type(request.getProduct().getType())
                .color(request.getProduct().getColor())
                .brand(request.getProduct().getBrand()).build(), request.getCategory());
        postWithOutPromo.increaseId();
        this.getterPosts().add(postWithOutPromo);
    }


    public void addPostWithPromo(PromoPostDTO request) {

        Post postWithOutPromo = new PostPromo(request.getUserId(), request.getDate()
                , request.getPrice(), Product.builder()
                .productName(request.getProduct().getProductName())
                .productId(request.getProduct().getProductId())
                .notes(request.getProduct().getNotes())
                .type(request.getProduct().getType())
                .color(request.getProduct().getColor())
                .brand(request.getProduct().getBrand()).build(), request.getCategory(), request.getHasPromo(), request.getDiscount());

        postWithOutPromo.increaseId();

        this.getterPosts().add(postWithOutPromo);
    }


    public List<Post> getPostBetweenDate() {

        return this.getterPosts().stream().filter(p -> p.getDate().isBefore(LocalDate.now())
                && p.getDate().isAfter(LocalDate.now().minusWeeks(2))).collect(Collectors.toList());
    }


}
