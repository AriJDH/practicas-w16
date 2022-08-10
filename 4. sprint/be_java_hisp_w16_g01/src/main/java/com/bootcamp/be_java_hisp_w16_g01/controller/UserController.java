package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    protected IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity addFollower(@PathVariable int userId, @PathVariable int userIdToFollow){
        userService.addFollower(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getCantFollowers(userId), HttpStatus.OK);
    }
}
