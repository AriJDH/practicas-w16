package com.example.be_java_hisp_w16_g03.repository;

import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> listUser;

    public UserRepository() {
        this.listUser = new ArrayList<>();
        this.listUser.addAll(initData());
    }


    @Override
    public List<User> postData(List<User> users) {
        listUser.addAll(users);
         return this.listUser;
    }

    @Override
    public List<User> initData() {

        List<User> initFollowers = new ArrayList<>();
        List<User> initFolloweds = new ArrayList<>();
        List<Post> initPost = new ArrayList<>();
        List<User> initUser = new ArrayList<>();
        User user1 = User.builder().userId(1).userName("pablo").build();
        User user2 = User.builder().userId(2).userName("emanuel").build();
        User user3 = User.builder().userId(3).userName("joaco").build();
        User user4 = User.builder().userId(4).userName("lucas").build();
        User user5 = User.builder().userId(5).userName("agustin").build();
        User user6 = User.builder().userId(6).userName("ivana").build();

        //------- inicializo la lista para los followeds
        //el uno sigue al dos
        initFolloweds.add(user2);
        user1.setFolloweds(initFolloweds);
        //------- inicializo la lista para los followers
        //al 2 los sigue el uno
        initFollowers.add(user1);
        initFollowers.add(user3);
        initFollowers.add(user4);
        user2.setFollowers(initFollowers);

        //---- inicializo la lista de user
        initUser.add(user1);
        initUser.add(user2);
        initUser.add(user3);
        initUser.add(user4);
        initUser.add(user5);
        initUser.add(user6);
        user1.setPosts(initPost);

        return initUser;
    }

    @Override
    public List<User> getAllUser() {
        return listUser;
    }

    @Override
    public User getUserById(Integer id) {
        return listUser.stream().filter(user -> user.getUserId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getFollowedsByUserId(Integer userId) {
        return listUser.stream().filter(u -> u.getUserId().equals(userId))
                .findFirst().get().getFolloweds();
    }

}
