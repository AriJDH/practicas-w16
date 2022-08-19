package com.example.be_java_hisp_w16_g03.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
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

    public List<User> getFollowers() {
        if (this.followers == null) {
            this.followers = new ArrayList<>();
        }
        return this.followers;
    }

    public List<User> getFolloweds() {
        if (this.followeds == null) {
            this.followeds = new ArrayList<>();
        }
        return this.followeds;
    }

    public List<Post> getPosts() {
        if (this.posts == null) {
            this.posts = new ArrayList<>();
        }
        return this.posts;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void addPostToUser(Post post) {
        post.increaseId();
        this.getPosts().add(post);
    }


    public List<Post> getPostLastTwoWeeks() {

        return this.getPosts()
                .stream()
                .filter(p -> p.getDate().isBefore(LocalDate.now()) && p.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList());
    }


}
