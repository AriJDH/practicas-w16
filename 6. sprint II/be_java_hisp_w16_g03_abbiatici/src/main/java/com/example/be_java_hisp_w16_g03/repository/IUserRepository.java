package com.example.be_java_hisp_w16_g03.repository;

import com.example.be_java_hisp_w16_g03.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> postData(List<User> users);

    List<User> getAllUser();

    Optional<User> getUserById(Integer id);

    List<User> getFollowedsByUserId(Integer userId);
}
