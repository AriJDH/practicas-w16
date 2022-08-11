package com.example.be_java_hisp_w16_g09_bariani.repository;

import com.example.be_java_hisp_w16_g09_bariani.model.User;

import java.util.List;

public interface IUserRepository {
    User createElement(User newUser);

    User searchById(int id);

    void updateUser(User user);

    List<User> getAllUsers();
}
