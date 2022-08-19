package com.example.be_java_hisp_w16_g09_Nicoletta.service;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.SimpleUserDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.UserFollowedDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.exception.*;
import com.example.be_java_hisp_w16_g09_Nicoletta.model.User;
import com.example.be_java_hisp_w16_g09_Nicoletta.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09_Nicoletta.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09_Nicoletta.utility.DTOMapperUtil;
import com.example.be_java_hisp_w16_g09_Nicoletta.utility.sort.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IPostRepository postRepository;

   @Autowired
    private DTOMapperUtil dtoMapperUtil;

    //Javi
    public void followUser(int userId, int userIdToFollow) {
        if (userId == userIdToFollow){throw new UserNotAllowedToFollowException(userId);}
        User userFollower = getValidatedUser(userId);
        User userToFollow = getValidatedUser(userIdToFollow);
        validateUserToFollowIsSeller(userToFollow);
        if(userFollower.isFollowing(userToFollow)){throw new UserAlreadyFollowedException(userIdToFollow);}
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
        if (user == null) {throw new UserNotFoundException(userId);}
        return user;
    }

    //Martin


    //MaxiM
    public UserFollowedDto getUsersFollowedBySellers(int userId, String order) {
        User user = getValidatedUser(userId);
        if (user.getFollowing().isEmpty()) {throw new UserDoesNotFollowedAnyone(userId);}
        List<SimpleUserDto> followed = dtoMapperUtil.mapList(user.getFollowing(), SimpleUserDto.class);

        followed = Sort.orderSequenceBasedOn(order, "name").sortingBy(SimpleUserDto::getUserName, followed);

        return new UserFollowedDto(user.getUserId(), user.getUserName(), followed);
    }

    //MaxiN
    public FollowersCountDTO followerCount(int id){
        FollowersCountDTO followersCountDTO = new FollowersCountDTO();
        followersCountDTO.setUser_id(id);
        User user = getValidatedUser (id);
        followersCountDTO.setUser_name(user.getUserName());
        int followersCount = 0;
        if(postRepository.searchById(id)!=null) followersCount = user.getFollowers().size();
        followersCountDTO.setFollowers_count(followersCount);
        return followersCountDTO;
    }

    public void unfollow(int userId, int userIdToUfollow){
        User unfollow = getValidatedUser(userIdToUfollow);
        User unfollow2 = getValidatedUser(userId);
        if (!userRepository.searchById(userId).isFollowing(unfollow)) throw new UserNotFollowing(userId,userIdToUfollow);
        else{
            userRepository.searchById(userId).getFollowing().remove(unfollow);
            userRepository.searchById(userIdToUfollow).getFollowers().remove(unfollow2);
        }
    }

    //Guille
    public FollowersDtoResponse getAllFollowers(int id, String order){
        User user = getValidatedUser(id);
        if (user.getFollowers().isEmpty()){throw new UserHasNoFollowersException(id);}
        List<SimpleUserDto> followers = dtoMapperUtil.mapList(user.getFollowers(), SimpleUserDto.class);
        followers = Sort.orderSequenceBasedOn(order, "name").sortingBy(SimpleUserDto::getUserName, followers);
        return new FollowersDtoResponse(user.getUserId(), user.getUserName(), followers);
    }
    //Nico
}





