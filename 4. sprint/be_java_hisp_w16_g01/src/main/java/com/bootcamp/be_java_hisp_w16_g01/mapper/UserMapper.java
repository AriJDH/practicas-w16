package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public UserDTO toDTO(User user){
        return  new UserDTO(user.getUserId(), user.getUserName() );
    }

    public UserFollowerDTO UserFollowerDTO(User user){
        List<UserDTO> followers = user.getFollowers().stream().map(this::toDTO).collect(Collectors.toList());
        return new UserFollowerDTO(user.getUserId(), user.getUserName(), followers);
    }
    public UserFollowedDTO UserFollowedDTO(User user){
        List<UserDTO> followed = user.getFollowed().stream().map(this::toDTO).collect(Collectors.toList());
        return new UserFollowedDTO(user.getUserId(), user.getUserName(), followed);
    }
}
