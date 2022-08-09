package com.example.be_java_hisp_w16_g03.repository;

import com.example.be_java_hisp_w16_g03.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> postData(List<User> users);
    List<User> initData();
    List<User> getAllUser();
    User getUserById(Integer id);
}
