package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class UserFollowersRepository {

    private List<User> usersList = new ArrayList<>();

    public UserFollowersRepository() {
        this.usersList = loadUser();
    }

    private List<User> loadUser() {

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:createUser.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;

        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

}
