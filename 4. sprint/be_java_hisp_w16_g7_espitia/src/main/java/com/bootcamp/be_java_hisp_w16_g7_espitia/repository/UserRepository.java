package com.bootcamp.be_java_hisp_w16_g7_espitia.repository;


import com.bootcamp.be_java_hisp_w16_g7_espitia.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    List<User> user;

    public UserRepository() {
        user = new ArrayList<>();

        User u1 = new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User u2 = new User(2222, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User u3 = new User(3333, "Me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User u4 = new User(4444, "Bob", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user.add(u1);
        user.add(u2);
        user.add(u3);
        user.add(u4);


    }

    @Override
    public boolean existsUser(int idUser) {
        for (User users : user) {
            if (users.getId() == idUser) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUserById(int id) {
        return user.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public void addToUserFollowers(User userToAdd, User user) {
        user.getFollowers().add(userToAdd);
    }

    @Override
    public void addToUserFollows(User userToAdd, User user) {
        user.getFollows().add(userToAdd);
    }

    @Override
    public void removeFromUserFollowers(User userToRemove, User user) {
        user.getFollowers().remove(userToRemove);
    }

    @Override
    public void removeFromUserFollows(User userToRemove, User user) {
        user.getFollows().remove(userToRemove);
    }


}
