package com.bootcamp.be_java_hisp_w16_g01.utils;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import java.util.ArrayList;
import java.util.List;

public class FactoryUser {

    public static List<User> getMockedUsers(){
        User user1= new User(1, "User1", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        User user2= new User(2, "User2", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        User user3= new User(3, "User3", new ArrayList<>(), new ArrayList<>(),new ArrayList<>());

        user1.addFollower(user2);
        user2.addFollowed(user1);

        user2.addFollower(user3);
        user3.addFollowed(user2);

        user3.addFollower(user2);
        user2.addFollowed(user3);

       return List.of(user1,user2,user3);
    }

}
