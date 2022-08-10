package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.mapper.UserMapper;


@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;
    private UserMapper userMapper = new UserMapper();

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {

        User userUnfollowing = this.userRepository.getUser(userId);
        User userToUnfollow = this.userRepository.getUser(userIdToUnfollow);

        if (userToUnfollow == null || userUnfollowing == null) {
            throw new BadRequestException("TODO");
        }

        if (!this.userRepository.userIsFollowed(userToUnfollow, userUnfollowing)
                || !this.userRepository.userIsFollower(userUnfollowing, userToUnfollow)
        ) {
            throw new BadRequestException("TODO-2");
        }

        userToUnfollow.getFollowers().remove(userUnfollowing);
        userUnfollowing.getFollowed().remove(userToUnfollow);

        return new UserUnfollowDTO("Ok", "User unfollowed succesfully");
    }


    public UserFollowerDTO getFollowers(int userId){
        User user = userRepository.getUser(userId);
        if(user != null){
            return userMapper.userFollowerDTO(user);
        } else {
            throw new BadRequestException("El usuario "+ userId +  " no existe");
        }
    }

    public UserFollowedDTO getFollowed(int userId) {
        User user = userRepository.getUser(userId);
        if(user != null){
            return userMapper.userFollowedDTO(user);
        } else {
            throw new BadRequestException("El usuario "+ userId +  " no existe");
        }
    }

    @Override
    public FollowersCountDTO getCantFollowers(int userId) {
        if (userRepository.userExists(userId)) {
            User usr = userRepository.getUser(userId);
            return new FollowersCountDTO(userId, usr.getUserName(), usr.getFollowers().size());
        } else throw new BadRequestException("Usuario con id: " + userId + " no existe");
    }

    public void addFollower(int userId, int userIdToFollow) {
        if (userRepository.userExists(userId)) {
            if (userRepository.userExists(userIdToFollow)) {
                if (userRepository.userIsSeller(userIdToFollow)) {
                    //si ya no lo sigue
                    if (!userRepository.getUser(userIdToFollow).getFollowers().contains(userRepository.getUser(userId))) {
                        userRepository.addFollower(userId, userIdToFollow);
                        userRepository.addFollowed(userId, userIdToFollow);
                    } else
                        throw new BadRequestException("Usuario con id: " + userId + " ya sigue al usuario con id: " + userIdToFollow);
                } else throw new BadRequestException("Usuario con id: " + userIdToFollow + " no es vendedor");
            } else throw new BadRequestException("Usuario con id: " + userIdToFollow + " no existe");
        } else throw new BadRequestException("Usuario con id: " + userId + " no existe");
    }


}
