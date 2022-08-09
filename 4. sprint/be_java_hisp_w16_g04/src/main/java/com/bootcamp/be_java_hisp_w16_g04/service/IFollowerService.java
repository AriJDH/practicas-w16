package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.User;

public interface IFollowerService {

  FollowUserDTO followUser(Integer userId, Integer userIdToFollow);
}
