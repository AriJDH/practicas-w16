package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;

import java.util.List;

public interface IUserService {
    public FollowersSellersDTO getSellersFollowers(int id);
}
