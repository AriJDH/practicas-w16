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
import java.util.Collections;
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
    public FollowersDTO getFollowers(Integer id, String order) {

        User user = repository.getUserById(id).orElseThrow(() -> new UserNotExistException(id));

        if (user.getFollowers() == null) {
            return new FollowersDTO(user.getUserId(), user.getUserName(), new ArrayList<>());
        }
        List<UserDTO> userDTO = user.getFollowers().stream().map(userA -> {
            UserDTO userDTO1 = new UserDTO();
            userDTO1.setUserId(userA.getUserId());
            userDTO1.setUserName(userA.getUserName());
            return userDTO1;
        }).collect(Collectors.toList());

        if (order != null) {
            if (order.equals(NAME_ASC)) {
                Collections.sort(userDTO, Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals(NAME_DESC)) {
                Collections.sort(userDTO, Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        FollowersDTO followersDTO = new FollowersDTO(user.getUserId(), user.getUserName(), userDTO);

        return followersDTO;
    }

    @Override
    public FollowedsDTO getFollowedUsers(Integer userId, String order) {
        User user = repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));

        FollowedsDTO dto = new FollowedsDTO();
        List<UserDTO> followersDto = new ArrayList<>();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());

        if (user.getFolloweds() == null) {
            dto.setFollowed(new ArrayList<>());
            return dto;
        }

        for (User follower : user.getFolloweds()) {
            followersDto.add(new UserDTO(follower.getUserId(), follower.getUserName()));
        }
        if (order != null) {
            if (order.equals(NAME_ASC)) {
                Collections.sort(followersDto, Comparator.comparing(UserDTO::getUserName));
            } else if (order.equals(NAME_DESC)) {
                Collections.sort(followersDto, Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        dto.setFollowed(followersDto);

        return dto;
    }

    @Override
    public FollowerCountDTO getCountFollowers(Integer id) {
        User user = repository.getUserById(id).orElseThrow(() -> new UserNotExistException(id));

        if (user.getFollowers() == null) {
            return new FollowerCountDTO(user.getUserId(), user.getUserName(), 0);
        }
        FollowerCountDTO followerCountDTO = new FollowerCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
        return followerCountDTO;
    }

    @Override
    public UserDTO followUser(Integer userId, Integer userToFollowId) {

        User user = repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));
        User userToFollow = repository.getUserById(userToFollowId).orElseThrow(() -> new UserNotExistException(userId));

        validateFollowUser(user, userToFollow);
        userToFollow.getFollowers().add(user);
        user.getFolloweds().add(userToFollow);

        return null;
    }

    private void validateFollowUser(User user, User userToFollow) {
        Boolean isSeller = userToFollow.getterPosts().size() > 0;
        Boolean follows = user.getterFolloweds().contains(userToFollow);
        Boolean isFollowed = userToFollow.getterFollowers().contains(user);

        if (follows || isFollowed) {
            throw new AlreadyFollowException(user.getUserId(), userToFollow.getUserId());
        }
        if (!isSeller) {
            throw new NotSellerException(userToFollow.getUserId());
        }
    }

    @Override
    public UserDTO unfollowUser(Integer userId, Integer userToUnfollowId) {
        User user = repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));
        User userToUnfollow = repository.getUserById(userToUnfollowId).orElseThrow(() -> new UserNotExistException(userToUnfollowId));

        Boolean unfollowDone = user.getterFolloweds().remove(userToUnfollow);
        Boolean followerRemove = userToUnfollow.getterFollowers().remove(user);
        if (!(unfollowDone && followerRemove)) {
            throw new NotFollowersException(userId, userToUnfollowId);
        }
        return null;
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++ Métodos Individuales ++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public List<UserDTO> getSellers() {
        List<User> users = repository.getAllUser();
        return users != null ? users.stream()
                .filter(user -> user.getterPosts().size() > 0)
                .map(seller -> new UserDTO(seller.getUserId(), seller.getUserName()))
                .collect(Collectors.toList()) : new ArrayList<>();

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++ Fin de Métodos Individuales +++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}
