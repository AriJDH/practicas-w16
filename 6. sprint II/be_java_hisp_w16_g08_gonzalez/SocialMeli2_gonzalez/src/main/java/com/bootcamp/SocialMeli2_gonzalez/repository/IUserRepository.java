package com.bootcamp.SocialMeli2_gonzalez.repository;

import com.bootcamp.SocialMeli2_gonzalez.entiry.User;

public interface IUserRepository {
    User getUserById(int id);
    void addUser(User user);
    boolean isPresent(int id);
}
