package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    protected List<User> users = new ArrayList<>();

    @Override
    public boolean unfollowUser(int userId, int userIdToUnfollow) {
        User userToUnfollow = this.users.stream()
                .filter(user -> user.getUserId() == userIdToUnfollow)
                .findFirst()
                .orElse(null);


        User userUnfollowing = this.users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);

        if (userToUnfollow == null || userUnfollowing == null) {
            throw new BadRequestException("TODO");
        }

        userToUnfollow.getFollowers().remove(userUnfollowing);
        userUnfollowing.getFollowed().remove(userToUnfollow);

        return true;
    }
}
