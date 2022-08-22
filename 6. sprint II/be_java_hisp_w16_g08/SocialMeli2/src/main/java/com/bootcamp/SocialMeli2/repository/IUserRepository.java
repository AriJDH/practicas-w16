package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entiry.User;

public interface IUserRepository {
    User getUserById(int id);
    void addUser(User user);
    boolean isPresent(int id);
}
