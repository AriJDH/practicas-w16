package com.bootcamp.be_java_hisp_w16_g7.repository;


import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    List<User> user;

    public UserRepository() {
        user = new ArrayList<>();

/*        Post post1 = new Post(1, 1, LocalDate.now(),new Product(1,"asd","asd","asd","asdqw","aqq"),new Category(1,"asd"),123,false,0);
        Post post2 = new Post(2, 1, LocalDate.now().minusDays(4),new Product(2,"asd","asd","asd","asdqw","aqq"),new Category(1,"asd"),123,false,0);*/
        User user1 = new User(1111, "User1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2222, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3333, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4444, "User4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        user.add(user1);
        user.add(user2);
        user.add(user3);
        user.add(user4);


        initUsers();

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

    private void initUsers() {
        User u1 = new User(1, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User u2 = new User(2, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User u3 = new User(3, "Me", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User u4 = new User(4, "Bob", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        u1.getFollows().add(u2);
        u1.getFollows().add(u3);
        u1.getFollows().add(u4);
        u3.getFollowers().add(u1);
        u3.getFollows().add(u2);
        u2.getFollowers().add(u1);
        u2.getFollowers().add(u3);
        u4.getFollowers().add(u1);
        user.add(u1);
        user.add(u2);
        user.add(u3);
        user.add(u4);
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
