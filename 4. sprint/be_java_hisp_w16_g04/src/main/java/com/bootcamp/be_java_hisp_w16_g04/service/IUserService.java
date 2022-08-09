package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.User;

import java.util.List;

public interface IUserService {


    ResponseFollowersListDTO getListFolloersById(Integer userId);

    UserFollowersCountDTO followersCount(Integer userId);

    UserFollowedDTO listUserFollowed(Integer userId);
}
