package com.bootcamp.be_java_hisp_w16_g01.repository;

public interface IUserRepository {
    boolean unfollowUser(int userId, int userIdToUnfollow);
}
