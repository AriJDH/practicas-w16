package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.exception.NotFoundException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public FollowersDTO getFollowers(Integer id) {
        User user=repository.getUserById(id);
        if (user==null){
            throw new UserNotExistException(id);
        }
        if (user.getFollowers()==null){
            return  new FollowersDTO(user.getUserId(), user.getUserName(), null);
        }
        List<UserDTO> userDTO= user.getFollowers().stream().map(userA->{
            UserDTO userDTO1=new UserDTO();
            userDTO1.setUserId(userA.getUserId());
            userDTO1.setUserName(userA.getUserName());
            return userDTO1;
                }).collect(Collectors.toList());
        FollowersDTO followersDTO= new FollowersDTO(user.getUserId(), user.getUserName(), userDTO);
        return followersDTO;
    }

    @Override
    public FollowerCountDTO getCountFollowers(Integer id) {
        User user = repository.getUserById(id);
        if (user == null) {
            throw new UserNotExistException(id);
        }
        if (user.getFollowers() == null) {
            return new FollowerCountDTO(user.getUserId(), user.getUserName(), 0);
        }
        FollowerCountDTO followerCountDTO = new FollowerCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size() - 1);
        return followerCountDTO;
    }

    public UserDTO followUser(Integer userId, Integer userToFollowId) {

        User user = repository.getUserById(userId);
        User userToFollow = repository.getUserById(userToFollowId);

        if (user == null || userToFollow == null) {
            throw new NotFoundException();
        }

        Boolean isSeller = userToFollow.validatePosts().size() == 0;
        Boolean follows = user.validateFolloweds().contains(userToFollow);
        Boolean isFollowed = userToFollow.validateFollowers().contains(user);

        if (follows || isFollowed || !isSeller) {
            throw new NotFoundException();
        }
        userToFollow.getFollowers().add(user);
        user.getFolloweds().add(userToFollow);

        return null;
    }

    public UserDTO unfollowUser(Integer userId, Integer userToUnfollowId) {

        User user = repository.getUserById(userId);
        User userToUnfollow = repository.getUserById(userToUnfollowId);

        if (user == null || userToUnfollow == null) {
            throw new NotFoundException();
        }

        Boolean unfollowDone = user.validateFolloweds().remove(userToUnfollow);
        Boolean followerRemove = userToUnfollow.validateFollowers().remove(user);

        if (!(unfollowDone && followerRemove)) {
            throw new NotFoundException();
        }
        return null;
    }
}
