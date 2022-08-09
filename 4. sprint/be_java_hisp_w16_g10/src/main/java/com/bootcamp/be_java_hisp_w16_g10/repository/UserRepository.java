package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class UserRepository implements IRepository{
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        this.users.add(User.builder().id(1).userName("user1").build());
        this.users.add(User.builder().id(2).userName("user2").build());
        this.users.add(User.builder().id(3).userName("user3").build());
        this.users.add(User.builder().id(4).userName("user4").build());
        this.users.add(User.builder().id(5).userName("user5").build());
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
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public void update(Integer id, User user) {
        User updateUser = this.findById(id);
        updateUser = user;
    }
    @Override
    public void addUserToList(List<User> users, User userToAdd) {
        boolean isInList = users.stream().anyMatch(user -> user.getId().equals(userToAdd.getId()));
        if(isInList) {
            throw new BadRequestException("The user is already following or is followed by the user");
        }
        users.add(userToAdd);
    }

    @Override
    public Integer getIndexOfUser(Integer userId) {
        return IntStream.range(0, users.size())
                .filter(userInd -> users.get(userId).getId().equals(userId))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public void updateUserInList(Integer index, User user) {
        users.set(index,user);
    }
}
