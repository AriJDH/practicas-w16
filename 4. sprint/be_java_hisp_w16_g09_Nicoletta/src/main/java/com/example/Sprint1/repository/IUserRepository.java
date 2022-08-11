package com.example.Sprint1.repository;

import com.example.Sprint1.model.User;

public interface IUserRepository {
    User createElement(User newUser);

    User searchById(int id);

    void updateUser(User user);
}
