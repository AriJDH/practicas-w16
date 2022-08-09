package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService service;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ExceptionApiDTO> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        Boolean response = service.followUser(userId, userIdToFollow);
        return response ? new ResponseEntity<>(null, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
