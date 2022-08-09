package com.bootcamp.be_java_hisp_w16_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;

    public User() {
        followers = new ArrayList<>();
        followed = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public Integer countFollowers(){
        return this.followers.size();
    }
}
