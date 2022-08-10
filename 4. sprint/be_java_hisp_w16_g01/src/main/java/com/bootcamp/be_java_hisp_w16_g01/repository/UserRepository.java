package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserRepository implements IUserRepository {

    protected List<User> users = new ArrayList<>();

    public UserRepository() {
        users = new ArrayList<>();

        //test
        User usuario1 = new User(0, "usuario1");
        User usuario2 = new User(1, "usuario2");
        User usuario3 = new User(2, "usuario3");
        User usuario4 = new User(3, "usuario4");
        usuario1.getFollowers().add(usuario2);
        usuario1.getFollowers().add(usuario3);
        usuario2.getFollowed().add(usuario1);
        usuario3.getFollowed().add(usuario1);

        users.add(usuario1);
        users.add(usuario2);
        users.add(usuario3);
        users.add(usuario4);

    }

    public void addFollower(int idUser, int userIdToFollow) {
        User userToFollow = users.stream().filter(user -> user.getUserId() == userIdToFollow).findFirst().get();
        User userFollows = users.stream().filter(u -> u.getUserId() == idUser).findFirst().get();

        userToFollow.addFollower(userFollows);
    }

    public void addFollowed(int idUser, int userIdToFollow) {
        User userFollowed = users.stream().filter(user -> user.getUserId() == userIdToFollow).findFirst().get();
        User userFollows = users.stream().filter(u -> u.getUserId() == idUser).findFirst().get();

        userFollows.addFollowed(userFollowed);
    }

    public boolean userExists(int idUser) {
        return users.stream().anyMatch(x -> x.getUserId() == idUser);
    }

    public boolean userIsSeller(int idUser) {
        return !users.stream().filter(u -> u.getUserId() == idUser).findFirst().get().getPosts().isEmpty();
    }

    @Override
    public User getUser(int userId) {
        return this.users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst().get();
    }

    public boolean userIsFollowed(User userFollowed, User userFollowingId) {
        return userFollowed
                .getFollowers()
                .stream()
                .anyMatch(follower -> follower.getUserId() == userFollowingId.getUserId());
    }

    public boolean userIsFollower(User userFollowing, User userFollowedId) {
        return userFollowing.getFollowed().stream()
                .anyMatch(followed -> followed.getUserId() == userFollowedId.getUserId());
    }
}
