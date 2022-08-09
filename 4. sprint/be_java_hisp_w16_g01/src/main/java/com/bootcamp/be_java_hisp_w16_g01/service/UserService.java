package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.mapper.UserMapper;
import com.bootcamp.be_java_hisp_w16_g01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;
    private UserMapper userMapper = new UserMapper();

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {
        if (this.userRepository.unfollowUser(userId, userIdToUnfollow)) {
            return new UserUnfollowDTO("Ok", "User unfollowed succesfully");
        }

        return new UserUnfollowDTO("Error", "An error has occurred");



    public UserFollowerDTO getFollowers(int userId){
        User user = repositoryUser.getUser(userId);
        if(user != null){
            return userMapper.UserFollowerDTO(user);
        } else {
            throw new BadRequestException("El usuario "+ userId +  " no existe");
        }
    }

    public UserFollowedDTO getFollowed(int userId) {
        User user = repositoryUser.getUser(userId);
        if(user != null){
            return userMapper.UserFollowedDTO(user);
        } else {
            throw new BadRequestException("El usuario "+ userId +  " no existe");
        }
    }
}
