package com.bootcamp.be_java_hisp_w16_g10_Lamela.repository;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.User;

import java.util.List;

public interface IUserRepository {
    User findById(Integer id);
    List<User> findAll();
    User save(User user);
    User update(User user);
}
