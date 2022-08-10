package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService service;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(service.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserDTO> unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return new ResponseEntity<>(service.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
