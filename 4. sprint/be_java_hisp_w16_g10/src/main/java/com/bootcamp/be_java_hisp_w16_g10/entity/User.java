package com.bootcamp.be_java_hisp_w16_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private List<User> followers = new ArrayList<>();
    private List<User> followed = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public Integer countFollowers(){
        return this.followers.size();
    }
}
