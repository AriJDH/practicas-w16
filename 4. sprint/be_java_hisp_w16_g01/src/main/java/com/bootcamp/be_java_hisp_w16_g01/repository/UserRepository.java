package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository implements IUserRepository {

    HashMap<Integer, User> users;

    public UserRepository(){
        users = new HashMap<>();

        users.put(0,new User(0, "usuario1"));
        users.put(1,new User(1, "usuario2"));
        users.put(2,new User(2, "usuario3"));
        users.put(3,new User(3, "usuario4"));
    }

    public void addFollower(int idUser, int idFollower){
        users.get(idUser).addFollower(users.get(idFollower));
    }

    public void addFollowed(int idUser, int idFollowed){
        users.get(idUser).addFollowed(users.get(idFollowed));
    }

    public boolean userExists(int idUser){
        return users.containsKey(idUser);
    }

}
