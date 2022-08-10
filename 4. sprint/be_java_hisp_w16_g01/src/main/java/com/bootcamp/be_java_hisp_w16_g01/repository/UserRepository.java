package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    protected List<User> users = new ArrayList<>();

    public UserRepository(){
        users = new ArrayList<>();

        users.add(new User(0, "usuario1"));
        users.add(new User(1, "usuario2"));
        users.add(new User(2, "usuario3"));
        users.add(new User(3, "usuario4"));
    }

    public void addFollower(int idUser, int userIdToFollow){
        User userToFollow = users.stream().filter(user -> user.getUserId() == userIdToFollow).findFirst().get();
        User userFollows = users.stream().filter(u -> u.getUserId() == idUser).findFirst().get();

        userToFollow.addFollower(userFollows);
    }

    public void addFollowed(int idUser, int userIdToFollow){
        User userFollowed = users.stream().filter(user -> user.getUserId() == userIdToFollow).findFirst().get();
        User userFollows = users.stream().filter(u -> u.getUserId() == idUser).findFirst().get();

        userFollows.addFollowed(userFollowed);
    }

    public boolean userExists(int idUser){
        return users.stream().anyMatch(x -> x.getUserId()==idUser);
    }

    public boolean userIsSeller(int idUser){
        return !users.stream().filter(u -> u.getUserId() == idUser).findFirst().get().getPosts().isEmpty();
    }

    @Override
    public boolean unfollowUser(int userId, int userIdToUnfollow) {
        User userToUnfollow = this.users.stream()
                .filter(user -> user.getUserId() == userIdToUnfollow)
                .findFirst()
                .orElse(null);


        User userUnfollowing = this.users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);

        if (userToUnfollow == null || userUnfollowing == null) {
            throw new BadRequestException("TODO");
        }

        userToUnfollow.getFollowers().remove(userUnfollowing);
        userUnfollowing.getFollowed().remove(userToUnfollow);

        return true;
    }


    @Override
    public User getUser(int userId) {
        return this.users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst().get();
    }


}
