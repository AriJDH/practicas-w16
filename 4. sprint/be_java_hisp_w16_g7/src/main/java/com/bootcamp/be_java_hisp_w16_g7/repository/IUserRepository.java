package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;

public interface IUserRepository {
    public User getSellersFollowers(int id);

}
