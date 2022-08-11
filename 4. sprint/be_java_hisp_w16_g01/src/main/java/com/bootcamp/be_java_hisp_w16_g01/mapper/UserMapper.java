package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public UserDto toDTO(User user){
        return  new UserDto(user.getUserId(), user.getUserName() );
    }
    public UserFollowerDto userFollowerDTO(List<User> followers, User user){
        return new UserFollowerDto(user.getUserId(), user.getUserName(), followers
                .stream().map(this::toDTO).collect(Collectors.toList()));
    }
    public UserFollowedDto userFollowedDTO(List<User> followed, User user){
        return new UserFollowedDto(user.getUserId(), user.getUserName(), followed
                .stream().map(this::toDTO).collect(Collectors.toList()));
    }
}
