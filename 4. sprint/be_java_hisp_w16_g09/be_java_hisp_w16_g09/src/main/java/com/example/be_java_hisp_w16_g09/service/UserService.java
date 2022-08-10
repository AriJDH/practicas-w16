package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09.dto.UserFollowedDto;
import com.example.be_java_hisp_w16_g09.exception.*;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IPostRepository postRepository;

    //Javi
    public void followUser(int userId, int userIdToFollow) {
        if (userId == userIdToFollow){
            throw new UserNotAllowedToFollowException(userId);
        }
        User userFollower = getValidatedUser(userId);
        User userToFollow = getValidatedUser(userIdToFollow);

        validateUserToFollowIsSeller(userToFollow);

        if(userFollower.isFollowing(userToFollow)){
            throw new UserAlreadyFollowedException(userIdToFollow);
        }

        userFollower.addFollowed(userToFollow);
        userToFollow.addFollower(userFollower);

        userRepository.updateUser(userFollower);
        userRepository.updateUser(userToFollow);
    }

    private void validateUserToFollowIsSeller(User anUser) {
        if (postRepository.searchById(anUser.getUserId()) == null)
            throw new UserToFollowIsNotSellerException(anUser.getUserId());
    }

    private User getValidatedUser(int userId) {
        User user = userRepository.searchById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    //Martin


    //MaxiM
    public UserFollowedDto getUsersFollowedBySellers(int userId) {
        User user = getValidatedUser(userId);
        if (user.getFollowing().isEmpty()) {throw new UserDoesNotFollowedAnyone(userId);}

        ModelMapper mapper = new ModelMapper();
        List<SimpleUserDto> followed = user.getFollowing().stream()
                .map(following -> mapper.map(following, SimpleUserDto.class))
                .collect(Collectors.toList());

        return new UserFollowedDto(user.getUserId(), user.getUserName(), followed);
    }

    //MaxiN
    public FollowersCountDTO followerCount(int id){
        FollowersCountDTO followersCountDTO = new FollowersCountDTO();
        followersCountDTO.setUser_id(id);

        User user = getValidatedUser (id);

        followersCountDTO.setUser_name(user.getUserName());
        int followersCount = 0;
        if(postRepository.searchById(id)!=null)
            followersCount = user.getFollowers().size();

        followersCountDTO.setFollowers_count(followersCount);
        return followersCountDTO;
    }

    public void unfollow(int userId, int userIdToUfollow){
        User unfollow = getValidatedUser(userIdToUfollow);
        User unfollow2 = getValidatedUser(userId);

        if (!userRepository.searchById(userId).isFollowing(unfollow))
            throw new UserNotFollowing(userId,userIdToUfollow);
        else{
            userRepository.searchById(userId).getFollowing().remove(unfollow);
            userRepository.searchById(userIdToUfollow).getFollowers().remove(unfollow2);
        }
    }

    public FollowersDtoResponse orderByName(int id, String order){
        FollowersDtoResponse followers = getAllFollowers(id);
        List<SimpleUserDto> listOrder =  followers.getFollowers().stream()
                .sorted(Comparator.comparing(SimpleUserDto::getUserName))
                .collect(Collectors.toList());
        if (order.equals("name_desc"))
            listOrder.sort(Comparator.comparing(SimpleUserDto::getUserName).reversed());
        followers.setFollowers(listOrder);
        return followers;
    }

    public UserFollowedDto orderByNameFollowed(int id, String order){
        UserFollowedDto followers = getUsersFollowedBySellers(id);
        List<SimpleUserDto> listOrder =  followers.getFollowing().stream()
                .sorted(Comparator.comparing(SimpleUserDto::getUserName))
                .collect(Collectors.toList());
        if (order.equals("name_desc"))
            listOrder.sort(Comparator.comparing(SimpleUserDto::getUserName).reversed());
        followers.setFollowing(listOrder);
        return followers;
    }

    //Guille
    public FollowersDtoResponse getAllFollowers(int id){
        User user = getValidatedUser(id);
        if (user.getFollowers().isEmpty()){
            throw new UserHasNoFollowersException(id);
        }else{
            ModelMapper mapper = new ModelMapper();
            List<SimpleUserDto> followers = new ArrayList<>();
            user.getFollowers().forEach(follower -> {
                SimpleUserDto followerOfUser = mapper.map(follower, SimpleUserDto.class);
                followers.add(followerOfUser);
            });
            return new FollowersDtoResponse(user.getUserId(), user.getUserName(), followers);
        }
    }
    //Nico
}





