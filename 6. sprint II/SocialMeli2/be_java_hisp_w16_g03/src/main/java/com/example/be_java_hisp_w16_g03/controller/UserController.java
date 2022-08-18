package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getCountFollowers(@PathVariable Integer userId) {
        return new ResponseEntity(service.getCountFollowers(userId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<>(service.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserDTO> unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return new ResponseEntity<>(service.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedsDTO> getFollowedUsers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getFollowedUsers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getMeFollowers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getFollowers(userId, order), HttpStatus.OK);
    }
}
