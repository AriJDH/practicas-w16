package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.ResponseUserInformationDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.ResponseVendorsFollowedDto;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public ResponseVendorsFollowedDto getVendorsFollowedByUser(int userId) {

        if(!userRepository.isPresent(userId)){
            throw new UserNotFoundException();
        }
        User serchedUser = userRepository.getUserById(userId);
        List<ResponseUserInformationDto> vendorsFollowed = serchedUser.getFollowedList().stream().
                                                                    filter(x->isVendor(x)).
                                                                    map(x->new ResponseUserInformationDto(x.getUserId(),x.getName()))
                                                                    .collect(Collectors.toList());

        return new ResponseVendorsFollowedDto(serchedUser.getUserId(),serchedUser.getName(),vendorsFollowed);
    }

    public boolean isVendor(User user){
        return user.getPostMade().size()>0;
    }
}
