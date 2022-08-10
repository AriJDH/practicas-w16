package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.ResponseUserInformationDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08.exception.UserNotFolllowException;
import com.bootcamp.be_java_hisp_w16_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService{
    final
    IUserRepository iUserRepository;
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }


    @Override
    public void addFollower(int idUser, int idUserToFollow) {
        User follower = getUserIfExist(idUser);
        User followed = getUserIfExist(idUserToFollow);
        followed.getFollowerList().add(follower);
        follower.getFollowedList().add(getUserIfExist(idUserToFollow));

    }
    @Override
    public UserFollowersCountDto getUserFollowerCount(int userId) {
        User user = getUserIfExist(userId);
        int followersCount = user.getFollowerList().size();
//        FALTA HACER FILTRADO POR SI ES VENDEDOR O NO
        return  new UserFollowersCountDto(user.getUserId(),user.getName(),followersCount);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow)  {
        User user = getUserIfExist(userId);
        User userToUnfollow = getUserIfExist(userIdToUnfollow);
        List<User> followers = user.getFollowedList();

        if(!followers.contains(userToUnfollow)){
            throw new UserNotFolllowException(String.valueOf(userId),String.valueOf(userIdToUnfollow));

        }

        user.getFollowedList().remove(userToUnfollow);
        userToUnfollow.getFollowerList().remove(user);
    }


    private User getUserIfExist(int idUser){
        if(!iUserRepository.isPresent(idUser)) {
            throw new UserNotFoundException(String.valueOf(idUser));
        }
        return iUserRepository.getUserById(idUser);
    }

    public UserDto getUserById(int idUser){
        User user =  getUserIfExist(idUser);

        List<ResponseUserInformationDto> followres = user.getFollowerList().stream().map(user1 -> new ResponseUserInformationDto(user1.getUserId(),user1.getName())).collect(Collectors.toList());

        List<ResponseUserInformationDto> followed = user.getFollowedList().stream().map(user1 ->
            new ResponseUserInformationDto(user1.getUserId(),user1.getName())).collect(Collectors.toList());

        return new UserDto(user.getUserId(), user.getName(),followres,followed);
    }
}
