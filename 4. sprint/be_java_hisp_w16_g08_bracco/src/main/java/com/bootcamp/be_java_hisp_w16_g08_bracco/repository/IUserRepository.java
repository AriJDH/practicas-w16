package com.bootcamp.be_java_hisp_w16_g08_bracco.repository;

import com.bootcamp.be_java_hisp_w16_g08_bracco.entiry.User;

public interface IUserRepository {
    User getUserById(int id);
    void addUser(User user);
    boolean isPresent(int id);
}
