package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;

    @Override
    public FollowersDTO getFollowers(Integer id) {
        User user=repository.getUserById(id);
        System.out.printf("paso");
        if (user==null){
            throw new UserNotExistException(id);
        }
        if (user.getFollowers()==null){
            return  new FollowersDTO(user.getUserId(), user.getUserName(), null);
        }
        List<UserDTO> userDTO= user.getFollowers().stream().map(userA->{
            UserDTO userDTO1=new UserDTO();
            userDTO1.setUserId(userA.getUserId());
            userDTO1.setUserName(userA.getUserName());
            return userDTO1;
                }).collect(Collectors.toList());
        FollowersDTO followersDTO= new FollowersDTO(user.getUserId(), user.getUserName(), userDTO);
        return followersDTO;
    }
}
