package com.bootcamp.be_java_hisp_w16_g01_rodriguez.service;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.*;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.User;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.mapper.UserMapper;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

    @Autowired
    protected IUserRepository userRepository;
    private UserMapper userMapper = new UserMapper();

    @Override
    public UserUnfollowDTO unfollowUser(int userId, int userIdToUnfollow) {

        validateUser(userId);
        validateUser(userIdToUnfollow);

        User userUnfollowing = this.userRepository.getUser(userId);
        User userToUnfollow = this.userRepository.getUser(userIdToUnfollow);
        validateUnFollow(userUnfollowing, userToUnfollow);

        userToUnfollow.getFollowers().remove(userUnfollowing);
        userUnfollowing.getFollowed().remove(userToUnfollow);

        return new UserUnfollowDTO("Ok", "Usuario dejado de seguir correctamente");
    }

    @Override
    public UserFollowerDTO getFollowers(int userId, String order) {

        String ord = order == null || order.isEmpty() ? "name_asc" : order;
        validateOrder(ord);

        validateUser(userId);
        User user = userRepository.getUser(userId);

        List<User> followers;
        if (ord.equalsIgnoreCase("name_asc")) {
            followers = user.getFollowers().stream()
                    .sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
        } else {
            followers = user.getFollowers().stream()
                    .sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList());
        }

        return userMapper.userFollowerDTO(followers, user);
    }


    @Override
    public UserFollowedDTO getFollowed(int userId, String order) {

        String ord = order == null || order.isEmpty() ? "name_asc" : order;
        validateOrder(ord);

        validateUser(userId);
        User user = userRepository.getUser(userId);

        List<User> followed;
        if (ord.equalsIgnoreCase("name_asc")) {
            followed = user.getFollowed().stream()
                    .sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
        } else {
            followed = user.getFollowed().stream()
                    .sorted(Comparator.comparing(User::getUserName).reversed()).collect(Collectors.toList());
        }
        return userMapper.userFollowedDTO(followed, user);
    }

    @Override
    public FollowersCountDTO getCantFollowers(int userId) {
        validateUser(userId);
        User usr = userRepository.getUser(userId);
        return new FollowersCountDTO(userId, usr.getUserName(), usr.getFollowers().size());
    }

    public MessageDTO addFollower(int userId, int userIdToFollow) {

        validateUser(userId);
        validateUser(userIdToFollow);
        validateFollower(userId, userIdToFollow);

        userRepository.addFollower(userId, userIdToFollow);
        userRepository.addFollowed(userId, userIdToFollow);

        return new MessageDTO("Usuario seguido correctamente");
    }

    private void validateUser(int userId) {
        if (!userRepository.userExists(userId))
            throw new BadRequestException("No existe el usuario con Id: " + userId);
    }

    private void validateFollower(int userId, int userIdToFollow) {
        if (userRepository.getUser(userIdToFollow).getFollowers().contains(userRepository.getUser(userId)))
            throw new BadRequestException("Usuario con id: " + userId + " ya sigue al usuario con id: " + userIdToFollow);
    }

    private void validateUnFollow(User user, User userToUnfollow) {
        if (!this.userRepository.userIsFollowed(userToUnfollow, user) || !this.userRepository.userIsFollower(user, userToUnfollow)) {
            throw new BadRequestException("El usuario : " + user.getUserId() + " no sigue al usuario : " + userToUnfollow.getUserId());
        }
    }

    private void validateOrder(String order) {
        if (!order.equals("name_desc") && !order.equals("name_asc"))
            throw new BadRequestException("El orden solicitado no es valido");
    }
}
