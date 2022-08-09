package com.bootcamp.be_java_hisp_w16_g7.repository;
import com.bootcamp.be_java_hisp_w16_g7.entity.Category;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    List<User> user;

    public UserRepository() {
        user = new ArrayList<>();
        Post post1 = new Post(1, LocalDate.now(),new Product(1,"asd","asd","asd","asdqw","aqq"),new Category(1,"asd"),123,false,0);
        Post post2 = new Post(2, LocalDate.now().minusDays(4),new Product(2,"asd","asd","asd","asdqw","aqq"),new Category(1,"asd"),123,false,0);
        User user1 = new User(1111, "User1", List.of(), List.of(),Arrays.asList(post1,post2) );
        User user2 = new User(2222, "User2", Arrays.asList(user1), Arrays.asList(user1), Arrays.asList(post2));
        User user3 = new User(3333, "User3", Arrays.asList(user2,user1), Arrays.asList(user2), Arrays.asList(post1));
        User user4 = new User(4444, "User4", Arrays.asList(user2,user3), Arrays.asList(user1), Arrays.asList(post1,post2));
        user.add(user1);
        user.add(user2);
        user.add(user3);
        user.add(user4);
    }

    @Override
    public boolean existsUser(int idUser) {
        for (User users: user) {
            if(users.getId()==idUser){
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
}
