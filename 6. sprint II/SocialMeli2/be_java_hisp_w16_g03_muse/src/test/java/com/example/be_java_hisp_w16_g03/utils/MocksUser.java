package com.example.be_java_hisp_w16_g03.utils;

import com.example.be_java_hisp_w16_g03.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MocksUser {

    public static final String NAME_DESC = "name_desc";
    public static final String NAME_ASC = "name_asc";

    public static User createSeller() {

        return User.builder().userId(2).userName("Seller1").posts(MocksPost.createPosts()).build();
    }

    public static User createUser() {

        return User.builder().userId(1).userName("User1").build();
    }

    public static List<User> createUserList() {

        List<User> followeds = new ArrayList<>();
        followeds.add(new User(4, "Carlos"));
        followeds.add(new User(3, "Briant"));
        followeds.add(new User(2, "Alberto"));


        return followeds;
    }


}
