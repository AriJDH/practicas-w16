package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    protected List<User> users = new ArrayList<>();

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





    private List<User> usuario = new ArrayList<>();
    private List<Post> postList = new ArrayList<>();

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

        usuario = List.of(user1,user2,user3,user4,user5);

        //Agrego los followers
        user1.addFollower(user3);
        //Agrego los followed
        user1.addFollowed(user3);

        user1.addFollowed(user4);
    }

    public User getUser(int userId) {
        return this.usuario.stream().filter(user -> user.getUserId() == userId).findFirst().orElse(null);
    }

    public List<User> getFollowers(int userId) {
        return getUser(userId).getFollowers();
    }
    public List<User> getFollowed(int userId) {
        return getUser(userId).getFollowed();
    }

}
