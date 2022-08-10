package com.bootcamp.be_java_hisp_w16_g7_espitia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private List<User> followers;
    private List<User> follows;
    private List<Post> posts;

    public Boolean isSeller() {
        return !posts.isEmpty();
    }


}
