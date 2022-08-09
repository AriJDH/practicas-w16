package com.example.be_java_hisp_w16_g03.entity;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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


    public List<User> validateFollowers() {
        if (this.followers == null) {
            this.followers = new ArrayList<>();
        }
        return this.followers;
    }

    public List<User> validateFolloweds() {
        if (this.followeds == null) {
            this.followeds = new ArrayList<>();
        }
        return this.followeds;
    }

    public List<Post> validatePosts() {
        if (this.posts == null) {
            this.posts = new ArrayList<>();
        }
        return this.posts;
    }


    public void addPostToUser(PostDTO request) {
        this.validatePosts().add(Post.builder()
                .userId(request.getUserId())
                .date(request.getDate())
                .price(request.getPrice())
                .product(Product.builder().
                        productId(request.getProduct().getProductId())
                        .brand(request.getProduct().getBrand())
                        .color(request.getProduct().getColor())
                        .type(request.getProduct().getType())
                        .notes(request.getProduct().getNotes())
                        .productName(request.getProduct().getProductName())
                        .build())
                .category(request.getCategory())
                .price(request.getPrice()).build());
    }


}
