package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.model.User;

public interface IUserRepository {

    User getByIdUser(Integer userId);
}
