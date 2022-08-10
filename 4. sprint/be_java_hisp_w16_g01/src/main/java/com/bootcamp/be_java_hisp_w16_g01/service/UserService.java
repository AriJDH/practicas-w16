package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {
        if (this.userRepository.unfollowUser(userId, userIdToUnfollow)) {
            return new UserUnfollowDTO("Ok", "User unfollowed succesfully");
        }

        return new UserUnfollowDTO("Error", "An error has occurred");
    }

    @Override
    public FollowersCountDTO getCantFollowers(int userId) {
        if (userRepository.userExists(userId)) {
            User usr = userRepository.getUser(userId);
            return new FollowersCountDTO(userId, usr.getUserName(), usr.getFollowers().size());
        }
        else throw new BadRequestException("Usuario con id: " + userId + " no existe");
    }

    public void addFollower(int userId, int userIdToFollow){
        if (userRepository.userExists(userId)) {
            if (userRepository.userExists(userIdToFollow)) {
                if (userRepository.userIsSeller(userIdToFollow)) {
                    //si ya no lo sigue
                    if (!userRepository.getUser(userIdToFollow).getFollowers().contains(userRepository.getUser(userId))){
                        userRepository.addFollower(userId, userIdToFollow);
                        userRepository.addFollowed(userId, userIdToFollow);
                    }
                    else throw new BadRequestException("Usuario con id: " + userId + " ya sigue al usuario con id: " + userIdToFollow);
                }
                else throw new BadRequestException("Usuario con id: " + userIdToFollow + " no es vendedor");
            }
            else throw new BadRequestException("Usuario con id: " + userIdToFollow + " no existe");
        }
        else throw new BadRequestException("Usuario con id: " + userId + " no existe");
    }


}
