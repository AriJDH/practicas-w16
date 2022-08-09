package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    List<User> user;

    public UserRepository() {
        user = new ArrayList<>();

        user.add(new User(1111, "User1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        user.add(new User(2222, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        user.add(new User(3333, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        user.add(new User(4444, "User4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    }


}
