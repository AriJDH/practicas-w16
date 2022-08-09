package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {
        if (this.userRepository.unfollowUser(userId, userIdToUnfollow)) {
            return new UserUnfollowDTO("Ok", "User unfollowed succesfully");
        }

        return new UserUnfollowDTO("Error", "An error has occurred");
    }
}
