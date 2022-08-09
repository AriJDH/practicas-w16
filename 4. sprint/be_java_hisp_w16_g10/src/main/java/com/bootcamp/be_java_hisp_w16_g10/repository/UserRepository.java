package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IRepository{
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public User findById(Integer id) {
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public void update(Integer id, User user) {
        User updateUser = this.findById(id);
        updateUser = user;
    }
}
