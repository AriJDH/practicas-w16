package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;


    @Override
    public FollowedsDTO getFollowedUsers(Integer userId, String order) {
        User user = repository.getUserById(userId);
        if (user == null){
            //return new UserNotFoundException();
        }
        FollowedsDTO dto = new FollowedsDTO();
        List<UserDTO> followersDto = new ArrayList<>();

        for (User follower : user.getFolloweds()) {
            followersDto.add(new UserDTO(follower.getUserId(), follower.getUserName()));
        }

        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        if (order != null){
            if (order.equals("name_asc")){
                Collections.sort(followersDto, Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals("name_desc")){
                Collections.sort(followersDto, Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        dto.setUserDtoList(followersDto);

        return dto;
    }
}
