package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;

public interface IUserRepository {
    User getUser(int userId);

    boolean unfollowUser(int userId, int userIdToUnfollow);
}
