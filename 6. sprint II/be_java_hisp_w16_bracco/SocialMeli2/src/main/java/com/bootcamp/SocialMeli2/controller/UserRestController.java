package com.bootcamp.SocialMeli2.controller;

import com.bootcamp.SocialMeli2.dto.response.UserDto;
import com.bootcamp.SocialMeli2.dto.response.UserFollowedDto;
import com.bootcamp.SocialMeli2.dto.response.UserFollowers;
import com.bootcamp.SocialMeli2.dto.response.UserFollowersCountDto;
import com.bootcamp.SocialMeli2.dto.response.ResponsePostFromFollowedDto;
import com.bootcamp.SocialMeli2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    IUserService userService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.addFollower(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDto> getUserFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getUserFollowerCount(userId), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> getVendorsFollowedByUser(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getVendorsFollowedByUser(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowers> requestAllFollowers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getAllVendorFollowers(userId, order), HttpStatus.OK);
    }


    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<ResponsePostFromFollowedDto> requestPostFromFollowed(@PathVariable int userId,
                                                                               @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getPostFromFollowed(userId, order), HttpStatus.OK);
    }

}
