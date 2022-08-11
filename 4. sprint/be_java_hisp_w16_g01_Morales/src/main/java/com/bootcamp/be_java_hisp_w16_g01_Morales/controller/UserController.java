package com.bootcamp.be_java_hisp_w16_g01_Morales.controller;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.*;
import com.bootcamp.be_java_hisp_w16_g01_Morales.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    protected IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.addFollower(userId, userIdToFollow),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> getFollowers(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(userService.getFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable int userId, @RequestParam String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getCantFollowers(userId), HttpStatus.OK);
    }

}
