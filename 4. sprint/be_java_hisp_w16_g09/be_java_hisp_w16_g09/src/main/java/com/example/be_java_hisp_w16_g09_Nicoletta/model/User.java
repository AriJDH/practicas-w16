package com.example.be_java_hisp_w16_g09_Nicoletta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();

    public void addFollower(User newFollower) {
        followers.add(newFollower);
    }

    public void addFollowed(User userToFollow) {
        following.add(userToFollow);
    }

    public boolean isFollowing(User user){
        return following.stream().anyMatch(u-> u.getUserId() == user.getUserId());
    }
}
