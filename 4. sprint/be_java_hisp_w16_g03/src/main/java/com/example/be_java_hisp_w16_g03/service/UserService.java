package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;


    @Override
    public FollowedsDTO getFollowedUsers(int userId) {
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
        dto.setUserDtoList(followersDto);

        return dto;
    }
}
