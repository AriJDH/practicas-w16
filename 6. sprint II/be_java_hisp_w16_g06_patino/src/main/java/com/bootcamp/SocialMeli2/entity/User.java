package com.bootcamp.SocialMeli2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private List<Follow> followed;
    private List<Follow> followers;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
