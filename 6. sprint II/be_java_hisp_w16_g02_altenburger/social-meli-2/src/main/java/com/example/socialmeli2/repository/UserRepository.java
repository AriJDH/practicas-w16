package com.example.socialmeli2.repository;

import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements  IRepository<User> {
    private Map<Integer, User> users = new HashMap<>();
    public UserRepository(){
        this.loadDataBase();
    }

    public void dropAll(){
        users.clear();
    }

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

    // private
    private void loadDataBase () {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Map<Integer, User>> typeRef = new TypeReference<>() {
        };

        try {
            file = ResourceUtils.getFile("classpath:users.json");
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
