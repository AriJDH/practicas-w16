package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;

import java.util.List;

public interface IUserService {


    ResponseFollowersListDTO getListFolloersById(Integer userId);



    UserFollowersCountDTO followersCount(Integer userId);
}
