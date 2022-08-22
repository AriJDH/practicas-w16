package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
