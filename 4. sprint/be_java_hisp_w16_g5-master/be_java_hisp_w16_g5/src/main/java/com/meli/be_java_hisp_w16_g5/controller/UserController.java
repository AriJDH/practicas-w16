package com.meli.be_java_hisp_w16_g5.controller;


import com.meli.be_java_hisp_w16_g5.dto.UserFollowerDto;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.service.IUserService;

import com.meli.be_java_hisp_w16_g5.dto.UserFollowedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userid}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable("userid") int userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getCountFollows(userId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> getFollowedsList(@PathVariable("userId") int userId, @RequestParam(value = "order",required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getFollowingSorted(userId,order),HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDto> getFollowers(@PathVariable int userId, @RequestParam(value = "order",required = false) String order) throws UserNotFoundException{
        return new ResponseEntity<>(userService.getFollowersSorted(userId,order), HttpStatus.OK);
    };

    @PostMapping("/{userid}/follow/{userIdToFollow}")
    public ResponseEntity<?> setUserFollowSeller(@PathVariable("userid") int userId, @PathVariable("userIdToFollow") int userIdToFollow ) throws UserNotFoundException {
        return ResponseEntity.ok(userService.setUserFollowSeller(userId,userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> setUnfollowSeller(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int userIdToFollow ) throws UserNotFoundException {
        return ResponseEntity.ok(userService.setUnfollowUser(userId,userIdToFollow));
    }




}
