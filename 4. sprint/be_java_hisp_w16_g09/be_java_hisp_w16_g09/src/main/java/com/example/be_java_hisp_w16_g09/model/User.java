package com.example.be_java_hisp_w16_g09.model;

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
}
