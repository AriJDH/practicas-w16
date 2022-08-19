package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.FollowedDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.UserDTO;

import java.util.List;

public interface IFollowersAndFollowedService {

    List<UserDTO> findById(int userId);

    FollowersDTO userFollowersOrder(int userId, String order);

    FollowersCountDTO userFollowers(Integer userId);

    FollowedDTO userFollowed(int userId, String order);

}
