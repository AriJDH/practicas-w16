package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.User;

import java.util.HashMap;

public class UserRepository {
    private HashMap<Integer, User> users = new HashMap<>();

    public User createElement(User newUser){
        newUser.setUserId(users.size()+1);
        users.put(newUser.getUserId(), newUser);
        return newUser;
    }

    public User searchById(int id){
        return users.get(id);
    }

    public void updateUser(User user){
        users.put(user.getUserId(),user);
    }
}
