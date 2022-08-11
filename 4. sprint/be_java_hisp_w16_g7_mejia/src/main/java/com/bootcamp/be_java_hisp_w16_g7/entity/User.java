package com.bootcamp.be_java_hisp_w16_g7.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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
