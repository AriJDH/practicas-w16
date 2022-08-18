package com.bootcamp.be_java_hisp_w16_g7.util;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUtil {

    public static User createUser(){
        List<Post> posts = List.of(new Post(2222, 1234, LocalDate.of(2022, 8, 10), new Product(), 99, 1000.0, false, 0.0),
                new Post(2222, 1234, LocalDate.of(2022, 7, 10), new Product(), 99, 1000.0, false, 0.0));
        List<User> followed = List.of(new User(2222, "User2", List.of(), List.of(), posts ));
        return new User(1111, "User1", List.of(), followed, List.of());
    }

    //Devuelve un vendedor con seguidores
    public static User expectedUser(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return new User(9999, "Pepito", Arrays.asList(follower1, follower2), new ArrayList<>(), Collections.singletonList(new Post()));

    }

    //Devuelve una lista de followers ordenados ascendentemente
    public static List<FollowersDTO> followersSortedListAsc(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        return List.of(
                new FollowersDTO(follower1.getId(), follower1.getName()),
                new FollowersDTO(follower2.getId(), follower2.getName())
        );
    }

    //Devuelve una lista de followers ordenados descendentemente
    public static List<FollowersDTO> followersSortedListDesc(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        return List.of(
                new FollowersDTO(follower2.getId(), follower2.getName()),
                new FollowersDTO(follower1.getId(), follower1.getName())
        );
    }
}
