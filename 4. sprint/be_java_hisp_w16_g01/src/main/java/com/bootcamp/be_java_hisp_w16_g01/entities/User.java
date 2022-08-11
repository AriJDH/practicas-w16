package com.bootcamp.be_java_hisp_w16_g01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(User user){
        this.followers.add(user);
    }

    public void addFollowed(User user) {
        this.followed.add(user);
    }

    public void addPost(Post p){
        this.posts.add(p);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", followersCount=" + followers.size() +
                ", followedCount=" + followed.size() +
                ", postsCount=" + posts.size() + "}";
    }

}
