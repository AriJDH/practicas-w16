package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;

public interface IUserService {
    UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow);
}
