package com.bootcamp.be_java_hisp_w16_g01.repository;

public interface IUserRepository {

    void addFollower(int idUser, int idFollower);

    void addFollowed(int idUser, int idFollowed);

    boolean userExists(int idUser);

    boolean unfollowUser(int userId, int userIdToUnfollow);
}
