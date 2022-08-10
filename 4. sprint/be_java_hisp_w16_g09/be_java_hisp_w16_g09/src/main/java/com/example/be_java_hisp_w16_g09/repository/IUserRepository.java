package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.User;

public interface IUserRepository {
    User createElement(User newUser);

    User searchById(int id);

    void updateUser(User user);
}
