package com.bootcamp.be_java_hisp_w16_g10_Lamela.repository;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        this.users.add(User.builder().id(1).userName("user1").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        this.users.add(User.builder().id(2).userName("user2").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        this.users.add(User.builder().id(3).userName("user3").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        this.users.add(User.builder().id(4).userName("user4").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        this.users.add(User.builder().id(5).userName("user5").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
    }

    @Override
    public User findById(Integer id) {
        return this.users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public User save(User user) {
        this.users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        this.users.set(this.getIndexOfUser(user.getId()), user);
        return user;
    }

    private Integer getIndexOfUser(Integer userId) {
        return IntStream.range(0, users.size())
                .filter(userInd -> users.get(userInd).getId().equals(userId))
                .findFirst()
                .orElse(-1);
    }
}
