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

    @Override
    public User findUserById(int userId) {
        User user = this.user.stream().filter(u -> u.getId()==userId).findFirst().orElse(null);
        return user;
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
