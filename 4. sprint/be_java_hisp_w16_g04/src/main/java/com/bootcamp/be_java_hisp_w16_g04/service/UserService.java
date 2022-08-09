package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IFollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g04.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IFollowerRepository iFollowerRepository;

    @Override
    public ResponseFollowersListDTO getListFolloersById(Integer userId) {

        User user = iUserRepository.getByIdUser(userId);

        List<User> FollowerList = iFollowerRepository.getFollewersListById(userId).stream()
                .map(id -> iUserRepository.getByIdUser(id))
                .collect(Collectors.toList());

        //Fill data
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        responseFollowersListDTO.setUserId(user.getUserId());
        responseFollowersListDTO.setUserName(user.getUserName());
        responseFollowersListDTO.setFollowers(FollowerList);

        return responseFollowersListDTO;
    }



    @Override
    public UserFollowersCountDTO followersCount(Integer userId) {

        User user = iUserRepository.getByIdUser(userId);
        List<Follower> followerList = iFollowerRepository.getFollowersByUserId(userId);

        if (user == null)
            throw new UserNotFoundException("User Not Found with User Id: " + userId);

        return new UserFollowersCountDTO(user.getUserId(), user.getUserName(), followerList.size());
    }


    @Override
    public UserFollowedDTO listUserFollowed (Integer userId) {
        UserFollowedDTO user = new UserFollowedDTO();
        User user1 = iUserRepository.getByIdUser(userId);

        if(user1==null){
            throw new UserNotFoundException("User Not Found with User Id: " + userId);
        }

        List<User> users = iFollowerRepository
                .returnIds(userId).stream()
                .map(id->iUserRepository.getByIdUser(id))
                .collect(Collectors.toList());

        user.setFollowed(users);

        user.setUser_id(userId);
        user.setUser_name(user1.getUserName());

        return user;
    }

}
