package com.bootcamp.be_java_hisp_w16_g01.repository;

public interface IUserRepository {
    boolean unfollowUser(int userId, int userIdToUnfollow);

    void addFollower(int idUser, int idFollower);

    void addFollowed(int idUser, int idFollowed);

    boolean userExists(int idUser);

}
