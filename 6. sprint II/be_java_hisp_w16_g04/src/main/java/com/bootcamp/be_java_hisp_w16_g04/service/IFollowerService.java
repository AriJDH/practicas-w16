package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;

public interface IFollowerService {

  FollowUserDTO followUser(Integer userId, Integer userIdToFollow);

  FollowUserDTO unFollowUser(Integer userId, Integer userIdToUnfollow);

}
