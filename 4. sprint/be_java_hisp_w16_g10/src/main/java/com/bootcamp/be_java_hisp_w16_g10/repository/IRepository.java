package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.User;

import java.util.List;

public interface IRepository {
    User findById(Integer id);
    List<User> findAll();
    void save(User user);
    void update(Integer userId, User user);
    Integer getIndexOfUser(Integer userId);
    void updateUserInList(Integer index, User user);
    void addUserToList(List<User> usersList, User userToAdd);
}
