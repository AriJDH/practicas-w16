package com.example.Sprint1.repository;

import com.example.Sprint1.model.User;
import com.example.Sprint1.utility.DataLoader;
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
    private void addUsers() {
        User userA = new User(1,"Mauricio",new ArrayList<>(),new ArrayList<>());
        User userB = new User(2,"Alvaro",new ArrayList<>(),new ArrayList<>());
        User userC = new User(3,"Juan",new ArrayList<>(),new ArrayList<>());
        User userD = new User(4,"Pedro",new ArrayList<>(),new ArrayList<>());
        User userE = new User(5,"Carlos",new ArrayList<>(),new ArrayList<>());
        users.put(1,userA);
        users.put(2,userB);
        users.put(3,userC);
        users.put(4,userD);
        users.put(5,userE);
    }
}
