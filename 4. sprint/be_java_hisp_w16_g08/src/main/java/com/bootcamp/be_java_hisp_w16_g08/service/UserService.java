package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowers;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowersList;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    ModelMapper mapper= new ModelMapper();
    @Override
    public UserFollowers getVendorsFollowedByUser(int userId) {

        if(!userRepository.isPresent(userId)){
            throw new UserNotFoundException();
        }
        User serchedUser = userRepository.getUserById(userId);
        List<UserFollowersList> vendorsFollowed = serchedUser.getFollowedList().stream().
                                                                    filter(x->isVendor(x)).
                                                                    map(x->new UserFollowersList(x.getUserId(),x.getName()))
                                                                    .collect(Collectors.toList());

        return new UserFollowers(serchedUser.getUserId(),serchedUser.getName(),vendorsFollowed);
    }

    public boolean isVendor(User user){
        return user.getPostMade().size()>0;
    }


    @Override
    public UserFollowers getAllFollowers(int id) {
        if (!userRepository.isPresent(id))
            throw new UserNotFoundException();

        return new UserFollowers(id, userRepository.getUserById(id).getName(), userRepository.getUserById(id).getFollowerList().stream()
                .filter(x->isVendor(userRepository.getUserById(id)))
                .map(user -> mapper.map(user,UserFollowersList.class))
                .collect(Collectors.toList()));
    }
}
