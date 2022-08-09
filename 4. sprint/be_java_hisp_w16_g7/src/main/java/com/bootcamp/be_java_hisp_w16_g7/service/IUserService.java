package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    HttpStatus follow(int userId, int userIdToFollow);
    HttpStatus unfollow(int userId, int userIdToUnfollow);
}
