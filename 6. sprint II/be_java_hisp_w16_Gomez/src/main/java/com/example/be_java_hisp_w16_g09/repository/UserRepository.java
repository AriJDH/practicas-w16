package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.utility.DataLoader;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRepository implements IUserRepository {
    private HashMap<Integer, User> users = new HashMap<>();

    public UserRepository() {
        DataLoader.loadUsers(this);
    }

    public User createElement(User newUser) {
        newUser.setUserId(users.size() + 1);
        users.put(newUser.getUserId(), newUser);
        return newUser;
    }

    public User searchById(int id) {
        return users.get(id);
    }

    public void updateUser(User user) {
        users.put(user.getUserId(), user);
    }
}
