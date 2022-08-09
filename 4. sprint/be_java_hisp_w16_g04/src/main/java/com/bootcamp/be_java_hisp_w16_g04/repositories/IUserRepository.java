package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.bootcamp.be_java_hisp_w16_g04.model.User;

import java.util.List;

public interface IUserRepository {
    User getByIdUser(Integer userId);

}
