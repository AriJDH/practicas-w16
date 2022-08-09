package com.example.be_java_hisp_w16_g03.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String userName;
    private List<User> followers;
    private List<User> followeds;
    private List<Post> posts;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
