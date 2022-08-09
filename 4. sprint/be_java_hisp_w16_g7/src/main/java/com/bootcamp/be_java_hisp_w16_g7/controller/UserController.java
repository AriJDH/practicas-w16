package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity(userService.unfollow(userId, userIdToUnfollow));
    }
}
