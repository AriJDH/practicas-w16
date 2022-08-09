package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IFollowerRepository iFollowerRepository;

    @Override
    public UserFollowersCountDTO followersCount(Integer userId) {

        User user = iUserRepository.getByIdUser(userId);
        List<Follower> followerList = iFollowerRepository.getFollowersByUserId(userId);

        if (user == null)
            throw new UserNotFoundException("User Not Found with User Id: " + userId);

        return new UserFollowersCountDTO(user.getUserId(), user.getUserName(), followerList.size());
    }
}
