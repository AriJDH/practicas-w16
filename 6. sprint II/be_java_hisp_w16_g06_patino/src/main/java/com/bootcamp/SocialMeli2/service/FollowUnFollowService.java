package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.FollowIdDto;
import com.bootcamp.SocialMeli2.dto.ResponseDTO;
import com.bootcamp.SocialMeli2.dto.UserDTO;
import com.bootcamp.SocialMeli2.entity.Follow;
import com.bootcamp.SocialMeli2.entity.User;
import com.bootcamp.SocialMeli2.exceptions.FollowException;
import com.bootcamp.SocialMeli2.exceptions.UserNotFoundException;
import com.bootcamp.SocialMeli2.repository.UserFollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FollowUnFollowService implements IFollowUnFollowService {

    int idFollower;
    int idFollowed;
    int idToUnfollow;

    static final String FOLLOW_SUCCESSFUL = "Follow Successful";
    static final String UNFOLLOW_SUCCESSFUL = "Unfollow Successful";
    static final String ALREADY_FOLLOWING = "Already following";
    static final String DENIED = "Follow/Unfollow Denied";
    @Autowired
    UserFollowersRepository userFollowersRepository;

    Map<Integer, String> followMap = new HashMap<Integer, String>();
    List<UserDTO> listUser = new ArrayList<>();

    ResponseDTO responseSpected;

    @Override
    public ResponseDTO followUser(FollowIdDto followIdDto) {

        idFollower = followIdDto.getUserId(); //  Seguidor
        idFollowed = followIdDto.getUserIdToFollow();//  Seguido

        existUser(idFollower);
        existUser(idFollowed);

        if (followMap.isEmpty()) {
            listUser = listUserDTO(userFollowersRepository.getUsersList());
            for (UserDTO follow : listUser) {
                followMap.put(follow.getUserId(), follow.getUserName());
            }
        }

        List<UserDTO> newListUser = new ArrayList<>();
        responseSpected = new ResponseDTO(DENIED, 404);
        for (UserDTO userDTO : listUser) {

            // Siguiendo A:
            List<Follow> followedList = new ArrayList<>();
            if (idFollower == userDTO.getUserId() && idFollowed != userDTO.getUserId()) {

                Follow following = new Follow(idFollowed, followMap.get(idFollowed));
                if (userDTO.getFollowed() != null) {
                    followedList = userDTO.getFollowed();
                }

                userDTO.setFollowed(followedList);
                if (userDTO.getFollowed() != null && !userDTO.getFollowed().contains(following)) {
                    followedList.add(following);
                    userDTO.setFollowed(followedList);
                } else {
                    throw new FollowException(ALREADY_FOLLOWING);
                }

            }

            // Seguido Por:
            List<Follow> followerList = new ArrayList<>();
            if (idFollowed == userDTO.getUserId() && idFollower != userDTO.getUserId()) {

                Follow followed = new Follow(idFollower, followMap.get(idFollower));
                if (userDTO.getFollowers() != null) {
                    followerList = userDTO.getFollowers();
                }

                userDTO.setFollowers(followerList);
                if (userDTO.getFollowers() != null && !userDTO.getFollowers().contains(followed)) {
                    followerList.add(followed);
                    userDTO.setFollowers(followerList);
                    responseSpected = new ResponseDTO(FOLLOW_SUCCESSFUL, 200);
                }
            }

            newListUser.add(userDTO);
        }

        userFollowersRepository.setUsersList(listUserEntity(newListUser));
        listUserDTO(userFollowersRepository.getUsersList());

        return responseSpected;
    }

    @Override
    public ResponseDTO unFollowUser(FollowIdDto followIdDto) {
        idFollower = followIdDto.getUserId(); //  Seguidor
        idToUnfollow = followIdDto.getUserIdToFollow();// !Seguido

        existUser(idFollower);
        existUser(idToUnfollow);

        if (followMap.isEmpty()) {
            listUser = listUserDTO(userFollowersRepository.getUsersList());
            for (UserDTO follow : listUser) {
                followMap.put(follow.getUserId(), follow.getUserName());
            }
        }

        List<UserDTO> newListUser = new ArrayList<>();
        responseSpected = new ResponseDTO(DENIED, 404);
        for (UserDTO userDTO : listUser) {

            // Quitar Siguiendo A:
            if (idFollower == userDTO.getUserId() && idToUnfollow != userDTO.getUserId()) {
                Follow unfollowing = new Follow(idToUnfollow, followMap.get(idToUnfollow));
                if (userDTO.getFollowed() != null || userDTO.getFollowed().isEmpty()) {
                    userDTO.getFollowed().remove(unfollowing);
                }
            }

            // Quitar Seguido Por:
            if (idToUnfollow == userDTO.getUserId() && idFollower != userDTO.getUserId()) {
                Follow unfollowed = new Follow(idFollower, followMap.get(idFollower));
                if (userDTO.getFollowers() != null || userDTO.getFollowers().isEmpty()) {
                    userDTO.getFollowers().remove(unfollowed);
                    responseSpected = new ResponseDTO(UNFOLLOW_SUCCESSFUL, 200);
                }
            }

            newListUser.add(userDTO);

        }
        listUserDTO(userFollowersRepository.getUsersList());

        return responseSpected;
    }

    @Override
    public boolean existUser(int userId) {

        List<User> users = userFollowersRepository.getUsersList()
                .stream()
                .filter(userDTO -> userDTO.getUserId() == userId)
                .collect(Collectors.toList());

        if (users.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        } else {
            return true;
        }

    }

    private List<UserDTO> listUserDTO(List<User> Users) {

        return Users.stream().map(user -> {
            UserDTO userDto = new UserDTO();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setFollowers(user.getFollowers());
            userDto.setFollowed(user.getFollowed());
            return userDto;
        }).collect(Collectors.toList());

    }

    private List<User> listUserEntity(List<UserDTO> userDTO) {

        return userDTO.stream().map(user -> {
            User userEntity = new User();
            userEntity.setUserId(user.getUserId());
            userEntity.setUserName(user.getUserName());
            userEntity.setFollowers(user.getFollowers());
            userEntity.setFollowed(user.getFollowed());
            return userEntity;
        }).collect(Collectors.toList());

    }

}
