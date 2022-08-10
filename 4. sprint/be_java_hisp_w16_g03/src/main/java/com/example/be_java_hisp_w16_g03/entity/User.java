package com.example.be_java_hisp_w16_g03.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

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



}
