package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository repository;

    @Override
    public FollowersDTO getFollowers(Integer id, String order) {
        User user=repository.getUserById(id);
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

        if (order != null) {
            if (order.equals("name_asc")) {
                Collections.sort(userDTO, Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals("name_desc")) {
                Collections.sort(userDTO, Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        FollowersDTO followersDTO = new FollowersDTO(user.getUserId(), user.getUserName(), userDTO);

        return followersDTO;
    }

    @Override
    public FollowedsDTO getFollowedUsers(Integer userId, String order) {
        User user = repository.getUserById(userId);
        if (user == null) {
            throw new UserNotExistException(userId);
        }
        FollowedsDTO dto = new FollowedsDTO();
        List<UserDTO> followersDto = new ArrayList<>();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());

        if (user.getFolloweds() == null){
            dto.setUserDtoList(new ArrayList<>());
            return dto;
        }

        for (User follower : user.getFolloweds()) {
            followersDto.add(new UserDTO(follower.getUserId(), follower.getUserName()));
        }
        if (order != null) {
            if (order.equals("name_asc")) {
                Collections.sort(followersDto, Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals("name_desc")) {
                Collections.sort(followersDto, Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        dto.setUserDtoList(followersDto);

        return dto;
    }
    public FollowerCountDTO getCountFollowers(Integer id) {
        User user=repository.getUserById(id);
        if (user==null){
            throw new UserNotExistException(id);
        }
        if (user.getFollowers()==null ){
            return  new FollowerCountDTO(user.getUserId(), user.getUserName(), 0);
        }
        FollowerCountDTO followerCountDTO=new FollowerCountDTO(user.getUserId(), user.getUserName(),user.getFollowers().size()-1);
        return followerCountDTO;
    }
}
