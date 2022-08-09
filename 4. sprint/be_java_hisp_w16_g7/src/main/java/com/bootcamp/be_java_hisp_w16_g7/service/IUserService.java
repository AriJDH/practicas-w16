package com.bootcamp.be_java_hisp_w16_g7.service;

import org.springframework.http.HttpStatus;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;


public interface IUserService {
    HttpStatus follow(int userId, int userIdToFollow);
    HttpStatus unfollow(int userId, int userIdToUnfollow);
    ResponseUserFollowedDTO getUserFollowedList(int id, String order);
}
