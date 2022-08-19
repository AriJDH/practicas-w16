package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.AlreadyFollowException;
import com.example.be_java_hisp_w16_g03.exception.NotFollowersException;
import com.example.be_java_hisp_w16_g03.exception.NotSellerException;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    public static final String NAME_ASC = "name_asc";
    public static final String NAME_DESC = "name_desc";

    @Autowired
    IUserRepository repository;

    @Override
    public User getUser(Integer userId) {
        return repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));
    }

    @Override
    public FollowersDTO getFollowers(Integer id, String order) {

        User user = repository.getUserById(id).orElseThrow(() -> new UserNotExistException(id));

        List<UserDTO> usersDTO = user.getFollowers()
                .stream()
                .map(userA -> new UserDTO(userA.getUserId(), userA.getUserName()))
                .collect(Collectors.toList());

        //Ordenamos ASC & DESC
        if (order != null) {
            if (order.equals(NAME_ASC)) {
                usersDTO.sort(Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals(NAME_DESC)) {
                usersDTO.sort(Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }

        return new FollowersDTO(user.getUserId(), user.getUserName(), usersDTO);
    }

    @Override
    public FollowedsDTO getFollowedUsers(Integer userId, String order) {
        User user = getUser(userId);

        FollowedsDTO followedsDTO = new FollowedsDTO();
        List<UserDTO> followersDto = new ArrayList<>();
        followedsDTO.setUserId(user.getUserId());
        followedsDTO.setUserName(user.getUserName());


        for (User follower : user.getFolloweds()) {
            followersDto.add(new UserDTO(follower.getUserId(), follower.getUserName()));
        }
        if (order != null) {
            if (order.equals(NAME_ASC)) {
                followersDto.sort(Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals(NAME_DESC)) {
                followersDto.sort(Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        followedsDTO.setFollowed(followersDto);

        return followedsDTO;
    }

    @Override
    public FollowerCountDTO getCountFollowers(Integer id) {
        User user = getUser(id);
        return new FollowerCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public UserDTO followUser(Integer userId, Integer userToFollowId) {

        User user = getUser(userId);
        User userToFollow = getUser(userToFollowId);

        boolean isSeller = userToFollow.getPosts().size() > 0;
        Boolean follows = user.getFolloweds().contains(userToFollow);
        Boolean isFollowed = userToFollow.getFollowers().contains(user);

        if (follows || isFollowed) {
            throw new AlreadyFollowException(userId, userToFollowId);
        }
        if (!isSeller) {
            throw new NotSellerException(userToFollow.getUserId());
        }
        userToFollow.getFollowers().add(user);
        user.getFolloweds().add(userToFollow);

        return null;
    }

    @Override
    public UserDTO unfollowUser(Integer userId, Integer userToUnfollowId) {

        User user = getUser(userId);
        User userToUnfollow = getUser(userToUnfollowId);

        Boolean unfollowDone = user.getFolloweds().remove(userToUnfollow);
        Boolean followerRemove = userToUnfollow.getFollowers().remove(user);
        if (!(unfollowDone && followerRemove)) {
            throw new NotFollowersException(userId, userToUnfollowId);
        }

        return null;
    }
}
