package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.be_java_hisp_w16_g01.mapper.UserMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;
    private UserMapper userMapper = new UserMapper();

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {

        User userUnfollowing = this.userRepository.getUser(userId);
        User userToUnfollow = this.userRepository.getUser(userIdToUnfollow);

        if (userToUnfollow == null )
            throw new BadRequestException("Usuario no existe id : " + userIdToUnfollow);
        if (userUnfollowing == null)
            throw new BadRequestException("Usuario no existe id : " + userId);

        if (!this.userRepository.userIsFollowed(userToUnfollow, userUnfollowing)
                || !this.userRepository.userIsFollower(userUnfollowing, userToUnfollow)
        ) {
            throw new BadRequestException("El usuario : " + userId + " no sigue al usuario : " + userIdToUnfollow );
        }

        userToUnfollow.getFollowers().remove(userUnfollowing);
        userUnfollowing.getFollowed().remove(userToUnfollow);

        return new UserUnfollowDTO("Ok", "Usuario dejado de seguir correctamente");
    }

    @Override
    public UserFollowerDTO getFollowers(int userId, String order) {
        User user = userRepository.getUser(userId);
        if(user != null){
            if (order!= null) {
                if (order.equalsIgnoreCase("name_asc")) {
                    List<User> followers = user.getFollowers().stream()
                            .sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
                    return userMapper.userFollowerDTO(followers, user);
                } else if (order.equalsIgnoreCase("name_desc")) {
                    List<User> followers = user.getFollowers().stream()
                            .sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList());
                    return userMapper.userFollowerDTO(followers, user);
                } else throw new BadRequestException("El orden no está definido");
            }
            else
                return userMapper.userFollowerDTO(user.getFollowers(), user);
        } else {
            throw new BadRequestException("El usuario "+ userId +  " no existe");
        }
    }


    @Override
    public UserFollowedDTO getFollowed(int userId, String order) {
        User user = userRepository.getUser(userId);
        if(user != null){
            if (order != null) {
                if (order.equalsIgnoreCase("name_asc")) {
                    List<User> followed = user.getFollowed().stream()
                            .sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
                    return userMapper.userFollowedDTO(followed, user);
                } else if (order.equalsIgnoreCase("name_desc")) {
                    List<User> followed = user.getFollowed().stream()
                            .sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList());
                    return userMapper.userFollowedDTO(followed, user);
                } else throw new BadRequestException("El orden no está definido");
            }
            else
                return userMapper.userFollowedDTO(user.getFollowed(), user);
        } else {
            throw new BadRequestException("El usuario "+ userId +  " no existe");
        }
    }

    @Override
    public FollowersCountDTO getCantFollowers(int userId) {
        if (userRepository.userExists(userId)) {
            User usr = userRepository.getUser(userId);
            return new FollowersCountDTO(userId, usr.getUserName(), usr.getFollowers().size());
        }
        else throw new BadRequestException("Usuario con id: " + userId + " no existe");
    }

    public MessageDto addFollower(int userId, int userIdToFollow){
        if (userRepository.userExists(userId)) {
            if (userRepository.userExists(userIdToFollow)) {
                if (userRepository.userIsSeller(userIdToFollow)) {
                    //si ya no lo sigue
                    if (!userRepository.getUser(userIdToFollow).getFollowers().contains(userRepository.getUser(userId))){
                        userRepository.addFollower(userId, userIdToFollow);
                        userRepository.addFollowed(userId, userIdToFollow);
                        return new MessageDto("Usuario seguido correctamente");
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
