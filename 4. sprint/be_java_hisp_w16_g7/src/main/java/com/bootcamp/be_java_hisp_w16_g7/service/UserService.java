package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserIsNotSellerException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public FollowersCountDto getFollowersCount(int id) {
        int countFollowers = 0;
        User userFound = userRepository.findUserById(id);
        if(userFound == null){
            throw new UserNotFoundException("User "+id+" not found");
        }
        int countPost = userFound.getPosts().size();
        if(countPost > 0){
            countFollowers = userFound.getFollowers().size();
        } else {
            throw new UserIsNotSellerException("User "+id+"  is not a seller!");
        }
        FollowersCountDto userFoundWithFollowers = new FollowersCountDto(userFound.getId(), userFound.getName(), countFollowers);
        return userFoundWithFollowers;
    }
}
