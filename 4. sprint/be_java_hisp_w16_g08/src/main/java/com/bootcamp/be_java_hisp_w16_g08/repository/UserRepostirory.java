package com.bootcamp.be_java_hisp_w16_g08.repository;

import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepostirory implements IUserRepository {
    Map<Integer, User> userCollection = new HashMap<>();


    public User getUserById(int id){
        return userCollection.get(id);
    }

    public void addUser(User user){
        this.userCollection.put(user.getUserId(),user);
    }
    public boolean isPresent(int id){
        return this.userCollection.containsKey(id);
    }

}
