package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity addFollower(@PathVariable int userId, @PathVariable int userIdToFollow){
        userService.addFollower(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
