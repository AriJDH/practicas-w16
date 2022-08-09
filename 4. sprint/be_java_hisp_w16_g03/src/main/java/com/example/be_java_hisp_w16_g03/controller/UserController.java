package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedsDTO> getFollowedUsers(@PathVariable Integer userId, @RequestParam String order){
        return new ResponseEntity<>(service.getFollowedUsers(userId, order), HttpStatus.OK);
    }
}
