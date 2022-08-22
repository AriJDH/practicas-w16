package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.exception.FollowerNotFoundException;
import com.example.socialmeli.exception.InputNotValidException;
import com.example.socialmeli.exception.UserAlreadyFollowingException;
import com.example.socialmeli.exception.UserNotFoundException;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IRepository;
import com.example.socialmeli.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    IRepository<User> userRepository;
    public void addFollower(Integer userId, Integer userIdFollowed) {
        if (userId.equals(userIdFollowed)) {
            throw new InputNotValidException("El usuario no puede seguirse a si mismo.");
        }
        User userFollowing = userRepository.getById(userId);
        User userFollowed = userRepository.getById(userIdFollowed);
        if (userFollowing == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        if (userFollowed == null) {
            throw new UserNotFoundException("El usuario con codigo " + userIdFollowed + " no existe.");
        }
        User userToFollow = userFollowing.getFollowed().stream()
                .filter(x -> x.getUserId() == userIdFollowed)
                .findFirst()
                .orElse(null);

        if (userToFollow != null) {
            throw new UserAlreadyFollowingException("El usuario " + userId + " ya sigue al usuario " + userIdFollowed + ".");
        }

        userFollowing.getFollowed().add(userFollowed);
        userFollowed.getFollowers().add(userFollowing);

        userRepository.update(userFollowing);
        userRepository.update(userFollowed);
    } //US0001
    public void removeFollower(Integer userId, Integer userIdToUnfollow) {
        User userFollowing = userRepository.getById(userId);
        User userFollowed = userRepository.getById(userIdToUnfollow);

        if (userFollowing == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        if (userFollowed == null) {
            throw new UserNotFoundException("El usuario con codigo " + userIdToUnfollow + " no existe.");
        }

        User userToUnfollow = userFollowing.getFollowed().stream()
                .filter(x -> x.getUserId() == userIdToUnfollow)
                .findFirst()
                .orElse(null);

        if (userToUnfollow == null) {
            throw new FollowerNotFoundException("No hay un seguidor con el id " + userIdToUnfollow + " en la lista de seguidores del usuario " + userId + ".");
        }

        userFollowing.getFollowed().remove(userFollowed);
        userFollowed.getFollowers().remove(userFollowing);

        userRepository.update(userFollowing);
        userRepository.update(userFollowed);

    }//US0007
    public UserFollowersCountDto getFollowersCountByUserId(Integer userId) {

        User userFollowing = userRepository.getById(userId);
        if (userFollowing == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        return Mapper.mapperToUserFollowersCountDto(userFollowing);

    }//US0002
    public UserFollowersListDto getFollowersListByUserId(Integer userId, Optional<String> order) {

        String orderString = order.orElse("");
        User user = userRepository.getById(userId);

        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        UserFollowersListDto followers = Mapper.mapperToUserFollowersListDto(user);

        if (orderString.equals("name_asc"))
            followers.getFollowers().sort(Comparator.comparing(UserDto::getUserName));
        else if (orderString.equals("name_desc"))
            followers.getFollowers().sort(Comparator.comparing(UserDto::getUserName).reversed());

        return followers;

    }//US0003 y US0008
    public UserFollowedListDto getFollowedListByUserId(Integer userId, Optional<String> order) {

        String orderString = order.orElse("");

        User user = userRepository.getById(userId);
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        UserFollowedListDto followed = Mapper.mapperToUserFollowedListDto(user);

        if (orderString.equals("name_asc"))
            followed.getFollowed().sort(Comparator.comparing(UserDto::getUserName));
        else if (orderString.equals("name_desc"))
            followed.getFollowed().sort(Comparator.comparing(UserDto::getUserName).reversed());

        return followed;
    }//US0004 y US0008

    @PostConstruct
    public void initUserData() {
        if (userRepository.getAll().isEmpty()) {
            User user1 = new User(0, "gonza", new ArrayList<User>(), new ArrayList<User>());
            User user2 = new User(0, "sabri", new ArrayList<User>(), new ArrayList<User>());
            User user3 = new User(0, "pame", new ArrayList<User>(), new ArrayList<User>());
            User user4 = new User(0, "mateo", new ArrayList<User>(), new ArrayList<User>());
            User user5 = new User(0, "erika", new ArrayList<User>(), new ArrayList<User>());
            User user6 = new User(0, "claudio", new ArrayList<User>(), new ArrayList<User>());

            userRepository.add(user1);
            userRepository.add(user2);
            userRepository.add(user3);
            userRepository.add(user4);
            userRepository.add(user5);
            userRepository.add(user6);
        }
    }
}
