package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private HashMap<Integer, User> users = new HashMap<>();

    public UserRepository() {
        this.addUsers();
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
    private void addUsers() {
        User userA = new User(1,"Usuario1",new ArrayList<>(),new ArrayList<>());
        User userB = new User(2,"Usuario2",new ArrayList<>(),new ArrayList<>());
        User userC = new User(3,"Usuario3",new ArrayList<>(),new ArrayList<>());
        User userD = new User(4,"Usuario4",new ArrayList<>(),new ArrayList<>());
        User userE = new User(5,"Usuario5",new ArrayList<>(),new ArrayList<>());
        users.put(1,userA);
        users.put(2,userB);
        users.put(3,userC);
        users.put(4,userD);
        users.put(5,userE);
    }
}
