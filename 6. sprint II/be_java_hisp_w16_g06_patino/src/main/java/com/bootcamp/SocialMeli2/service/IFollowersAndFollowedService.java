package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.FollowedDTO;
import com.bootcamp.SocialMeli2.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli2.dto.FollowersDTO;
import com.bootcamp.SocialMeli2.dto.UserDTO;

import java.util.List;

public interface IFollowersAndFollowedService {

    List<UserDTO> findById(int userId);

    FollowersDTO userFollowersOrder(int userId, String order);

    FollowersCountDTO userFollowers(Integer userId);

    FollowedDTO userFollowed(int userId, String order);

}
