package com.example.be_java_hisp_w16_g03.utils;

import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.User;

import java.util.ArrayList;
import java.util.List;

public class initUsers {

    public static List<User> initUserList (){

        List<User> initUser = new ArrayList<>();
        User user1 = MocksUser.createUser();
        User user2 = MocksUser.createSeller();

        //------- inicializo la lista para los followeds
        //el uno sigue al dos
        user1.setFolloweds(List.of(user2));
        //------- inicializo la lista para los followers
        //al 2 los sigue el uno
        user2.setFollowers(List.of(user1));

        //---- inicializo la lista de user
        initUser.add(user1);
        initUser.add(user2);

        return initUser;
    }

}
