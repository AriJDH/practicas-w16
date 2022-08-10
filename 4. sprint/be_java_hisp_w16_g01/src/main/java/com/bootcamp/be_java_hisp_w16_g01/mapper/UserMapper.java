package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;

import java.util.Comparator;
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
