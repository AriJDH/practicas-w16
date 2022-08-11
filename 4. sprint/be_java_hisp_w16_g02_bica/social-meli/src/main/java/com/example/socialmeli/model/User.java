package com.example.socialmeli.model;

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
    private List<User> followers;//Son los usuarios que me siguen
    private List<User> followed;//Son los usuarios que yo sigo
}


