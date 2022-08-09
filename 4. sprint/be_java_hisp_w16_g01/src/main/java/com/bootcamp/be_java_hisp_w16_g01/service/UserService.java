package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    IUserRepository userRepository;

    public UserService (IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addFollower(int userId, int userIdToFollow){
        if (userRepository.userExists(userId)) {
            if (userRepository.userExists(userIdToFollow)) {
                userRepository.addFollower(userIdToFollow, userId);
                userRepository.addFollowed(userId, userIdToFollow);
            }
            else throw new BadRequestException("Usuario con id: " + userIdToFollow + "no existe");
        }
        else throw new BadRequestException("Usuario con id: " + userId + "no existe");
    }



}
