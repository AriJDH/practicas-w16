package com.bootcamp.be_java_hisp_w16_g08_negreyra.repository;

import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.User;
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
