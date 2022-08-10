package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;

public interface IUserRepository {

    User getUser(int userId);

    void addFollower(int idUser, int userIdToFollow);

    void addFollowed(int idUser, int idFollowed);

    boolean userExists(int idUser);

    boolean userIsSeller(int idUser);

    boolean userIsFollower(User userFollowing, User userFollowedId);

    boolean userIsFollowed(User userFollowed, User userFollowingId);
}
