package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public UserDTO toDTO(User user){
        return  new UserDTO(user.getUserId(), user.getUserName() );
    }

    public UserFollowerDTO userFollowerDTO(List<User> followers, User user){
        return new UserFollowerDTO(user.getUserId(), user.getUserName(), followers.stream().map(this::toDTO).collect(Collectors.toList()));
    }

    public UserFollowedDTO userFollowedDTO(List<User> followed, User user){
        return new UserFollowedDTO(user.getUserId(), user.getUserName(), followed.stream().map(this::toDTO).collect(Collectors.toList()));
    }
}
