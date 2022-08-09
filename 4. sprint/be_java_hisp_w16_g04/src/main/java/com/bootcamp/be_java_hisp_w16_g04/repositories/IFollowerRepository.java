package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.User;

import java.util.List;

public interface IFollowerRepository {
    List<Integer> getFollewersListById(Integer userId);
}
