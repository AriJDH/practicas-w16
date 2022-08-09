package com.bootcamp.be_java_hisp_w16_g7.repository;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;

public interface IUserRepository {
    User findUserById(int userId);
    void addToUserFollowers(User userToAdd, User target);
    void addToUserFollows(User userToAdd, User target);
    void removeFromUserFollowers(User userToRemove, User target);
    void removeFromUserFollows(User userToRemove, User target);


}
