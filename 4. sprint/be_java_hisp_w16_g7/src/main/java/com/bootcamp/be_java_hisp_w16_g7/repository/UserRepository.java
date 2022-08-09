package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Category;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    List<User> user;

    public UserRepository() {
        user = new ArrayList<>();

        //Test
        List<User> followersTest = new ArrayList<>();
        List<Post> postTest = new ArrayList<>();
        postTest.add(new Post(116, LocalDate.now(), new Product(88, "product1", "type1", "brand1", "red", "note1"), new Category(01, "c1"), 134, false, 12));
        followersTest.add(new User(122, "Follower1", List.of(), List.of(), List.of()));
        followersTest.add(new User(567, "Follower2", List.of(), List.of(), List.of()));


        user.add(new User(1111, "User1", followersTest, List.of(), postTest));
        user.add(new User(2222, "User2", List.of(), List.of(), List.of()));
        user.add(new User(3333, "User3", List.of(), List.of(), List.of()));
        user.add(new User(4444, "User4", List.of(), List.of(), List.of()));
    }

    //Obtener lista de seguidores de un vendedor
    public User getSellersFollowers(int id){
       Optional<User> filteredUser = user.stream().filter(u -> u.getId() == id && u.getPosts().size() > 0).findFirst();
        return filteredUser.orElse(null);
    }
}
