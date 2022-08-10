package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    protected List<User> users = new ArrayList<>();

    public UserRepository(){
        LoadData();
    }

    private void LoadData(){

        // las listas se inicializan sin valores ya que al crearse un usuario no
        // posee seguidos, seguidores o posts

        User user1= new User(1, "Vendedor1", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        User user2= new User(2, "Vendedor2", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        User user3= new User(3, "Usuario3", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        User user4= new User(4, "Usuario4", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        User user5= new User(5, "Vendedor5", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());

        users = List.of(user1,user2,user3,user4,user5);

        //Agrego los followers
        user1.addFollower(user3);

        //Agrego los followed
        user1.addFollowed(user3);
        user1.addFollowed(user4);
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

    public User getUser(int userId) {
        return this.users.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);
    }

}
