package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
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

        User user = userRepository.getByIdUser(userId);

        List<User> FollowerList = followerRepository.getFollewersListById(userId).stream()
                .map(id -> userRepository.getByIdUser(id))
                .collect(Collectors.toList());

        //Fill data
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        responseFollowersListDTO.setUserId(user.getUserId());
        responseFollowersListDTO.setUserName(user.getUserName());
        responseFollowersListDTO.setFollowers(FollowerList);

        return responseFollowersListDTO;
    }

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
