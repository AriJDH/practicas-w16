package com.example.socialmeli.repository;

import com.example.socialmeli.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements  IRepository<User>{
    private Map<Integer, User> users = new HashMap<>();
    @Override
    public User getById(Integer id) {
        return users.get(id);
    }
    @Override
    public List<User> getAll() {
        return users.values().stream().collect(Collectors.toList());
    }
    @Override
    public void update(User user) {
        users.put(user.getUserId(),user);
    }
    @Override
    public Integer add(User user) {
        Integer id = users.size() + 1;
        user.setUserId(id);
        users.put(id,user);
        return id;
    }
}
