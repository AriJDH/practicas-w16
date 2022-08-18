package com.bootcamp.be_java_hisp_w16_g7.util;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;

import java.time.LocalDate;
import java.util.List;

public class TestUtil {

    public static User createUser(){
        List<Post> posts = List.of(new Post(2222, 1234, LocalDate.of(2022, 8, 10), new Product(), 99, 1000.0, false, 0.0),
                new Post(2222, 1234, LocalDate.of(2022, 7, 10), new Product(), 99, 1000.0, false, 0.0));
        List<User> followed = List.of(new User(2222, "User2", List.of(), List.of(), posts ));
        return new User(1111, "User1", List.of(), followed, List.of());
    }
}
