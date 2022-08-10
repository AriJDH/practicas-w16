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
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IFollowerRepository iFollowerRepository;

    @Override
    public ResponseFollowersListDTO getListFollowersById(Integer userId, String order) {

        User user = iUserRepository.getByIdUser(userId);

        List<User> FollowerList = iFollowerRepository.getFollewersListById(userId).stream()
                .map(id -> iUserRepository.getByIdUser(id))
                .collect(Collectors.toList());

        if (order.equals("name_asc")){
            FollowerList = FollowerList.stream().sorted(Comparator.comparing(User::getUserName))
                    .collect(Collectors.toList());
        }
        else if(order.equals("name_desc")){
            FollowerList = FollowerList.stream().sorted(Comparator.comparing(User::getUserName).reversed())
                    .collect(Collectors.toList());
        }

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
    public UserFollowedDTO orderListUserFollowed (Integer userId, String order) {

        System.out.println(order);

        UserFollowedDTO user = new UserFollowedDTO();
        User user1 = iUserRepository.getByIdUser(userId);

        if(user1==null){
            throw new UserNotFoundException("User Not Found with User Id: " + userId);
        }

        List<User> users = iFollowerRepository
                .returnIds(userId).stream()
                .map(id->iUserRepository.getByIdUser(id))
                .collect(Collectors.toList());

        if (order.equals("name_asc")){
            System.out.println("Funciona");
            users = users.stream().sorted(Comparator.comparing(User::getUserName))
                    .collect(Collectors.toList());
        }
        else if(order.equals("name_desc")){
            System.out.println("Hey");
            users = users.stream().sorted(Comparator.comparing(User::getUserName).reversed())
                    .collect(Collectors.toList());
        }

        user.setFollowed(users);

        user.setUser_id(userId);
        user.setUser_name(user1.getUserName());

        return user;
    }






}
