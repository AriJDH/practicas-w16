package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.UserUnfollowDTO;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01.dto.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import com.bootcamp.be_java_hisp_w16_g01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    protected IUserService userService;

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> getFollowers(@PathVariable int userId){
        return new ResponseEntity<>(serviceUser.getFollowers(userId), HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable int userId){
        return new ResponseEntity<>(serviceUser.getFollowed(userId), HttpStatus.OK);
    }

}
