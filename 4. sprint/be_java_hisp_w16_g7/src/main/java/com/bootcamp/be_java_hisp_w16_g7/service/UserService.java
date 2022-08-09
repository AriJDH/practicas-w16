package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public HttpStatus follow(int userId, int userIdToFollow) {
        User user = userRepository.findUserById(userId);
        User target = userRepository.findUserById(userIdToFollow);

        if(user == null) throw new UserNotFoundException(userId);
        if(target == null) throw new UserNotFoundException(userIdToFollow);
        if(!target.isSeller() || target.getFollowers().contains(user)) return HttpStatus.BAD_REQUEST;

        userRepository.addToUserFollows(target, user);
        userRepository.addToUserFollowers(user, target);

        return HttpStatus.OK;
    }

    @Override
    public HttpStatus unfollow(int userId, int userIdToUnfollow){
        User user = userRepository.findUserById(userId);
        User target = userRepository.findUserById(userIdToUnfollow);

        if(user == null) throw new UserNotFoundException(userId);
        if(target == null) throw new UserNotFoundException(userIdToUnfollow);
        if(!target.getFollowers().contains(user)) return HttpStatus.BAD_REQUEST;

        userRepository.removeFromUserFollows(target, user);
        userRepository.removeFromUserFollowers(user, target);

        return HttpStatus.OK;
    }


}
