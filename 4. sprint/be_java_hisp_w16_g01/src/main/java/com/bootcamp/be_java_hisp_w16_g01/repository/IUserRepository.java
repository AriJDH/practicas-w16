package com.bootcamp.be_java_hisp_w16_g01.repository;

public interface IUserRepository {

    public void addFollower(int idUser, int userIdToFollow);

    public void addFollowed(int idUser, int idFollowed);

    public boolean userExists(int idUser);
    public boolean userIsSeller(int idUser);

    boolean unfollowUser(int userId, int userIdToUnfollow);
}
