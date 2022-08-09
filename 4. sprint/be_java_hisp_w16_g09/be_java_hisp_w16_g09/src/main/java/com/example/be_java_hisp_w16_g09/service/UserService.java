package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.dto.UserDto;
import com.example.be_java_hisp_w16_g09.exception.GlobalHandler;
import com.example.be_java_hisp_w16_g09.exception.UserHasNoFollowersException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IPostRepository postRepository;

    //Javi


    //Martin


    //MaxiM


    //MaxiN
    public FollowersCountDTO followerCount(int id){
        FollowersCountDTO followersCountDTO = new FollowersCountDTO();
        followersCountDTO.setUser_id(id);
        if (userRepository.searchById(id) == null)
            throw new UserNotFoundException(id);

        followersCountDTO.setUser_name(userRepository.searchById(id).getUserName());
        int followersCount = 0;
        if(postRepository.searchById(id)!=null)
            followersCount = userRepository.searchById(id).getFollowers().size();

        followersCountDTO.setFollowers_count(followersCount);
        return followersCountDTO;
    }


    //Guille
    public FollowersDtoResponse getAllFollowers(int id){
        User user = userRepository.searchById(id);
        if (user == null){
            throw new UserNotFoundException(id);
        }else{
            if (user.getFollowers().isEmpty()){
                throw new UserHasNoFollowersException(id);
            }else{
                ModelMapper mapper = new ModelMapper();
                List<SimpleUserDto> followers = new ArrayList<>();
                user.getFollowers().forEach(follower -> {
                    SimpleUserDto followerOfUser = mapper.map(follower, SimpleUserDto.class);
                    followers.add(followerOfUser);
                });
                FollowersDtoResponse response = new FollowersDtoResponse(user.getUserId(), user.getUserName(), followers);
                return response;
            }
        }
    }

    //Nico



}
