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

<<<<<<< HEAD
    public User(int userId, String userName){
        this.followed = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower(User user){
        this.followers.add(user);
        //user.addFollowed(this);
    }
    public void addFollowed(User user){
        this.followed.add(user);
        //user.addFollower(this);
=======
    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addFollower (User user){
        followers.add(user);
    }

    public void addFollowed (User user){
        followed.add(user);
>>>>>>> a57855611a977f53e39c6e1e270323cd9dda0f55
    }

}
