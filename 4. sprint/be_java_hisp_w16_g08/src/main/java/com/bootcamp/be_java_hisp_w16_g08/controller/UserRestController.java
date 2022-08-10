package com.bootcamp.be_java_hisp_w16_g08.controller;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowers;
import com.bootcamp.be_java_hisp_w16_g08.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    IUserService userService;


    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowers> getVendorsFollowedByUser (@PathVariable int userId){
        return new ResponseEntity<>(userService.getVendorsFollowedByUser(userId), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowers> requestAllFollowers(@PathVariable int userId){

        return new ResponseEntity<>(userService.getAllFollowers(userId), HttpStatus.OK);
    }

}
