package com.example.be_java_hisp_w16_g09_Nicoletta.repository;

import com.example.be_java_hisp_w16_g09_Nicoletta.model.User;

public interface IUserRepository {
    User createElement(User newUser);

    User searchById(int id);

    void updateUser(User user);
}
