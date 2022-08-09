package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    IFollowerRepository followerRepository;
    IUserRepository userRepository;

    @Autowired
    public UserService(IFollowerRepository followerRepository,IUserRepository userRepository){
        this.followerRepository = followerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseFollowersListDTO getListFolloersById(Integer userId) {

        User user = userRepository.getUserById(userId);

        List<User> FollowerList = followerRepository.getFollewersListById(userId).stream()
                .map(id -> userRepository.getUserById(id))
                .collect(Collectors.toList());

        //Fill data
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        responseFollowersListDTO.setUserId(user.getUserId());
        responseFollowersListDTO.setUserName(user.getUserName());
        responseFollowersListDTO.setFollowers(FollowerList);

        return responseFollowersListDTO;
    }
}
