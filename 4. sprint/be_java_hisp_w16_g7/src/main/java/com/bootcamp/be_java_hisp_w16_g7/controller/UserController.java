package com.bootcamp.be_java_hisp_w16_g7.controller;


import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseUserFollowedDTO> getUserFollowedList(@PathVariable int userId,
                                                                       @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getUserFollowedList(userId, order), HttpStatus.OK);

    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersSellersDTO> getSellersFollowers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getSellersFollowers(userId, order), HttpStatus.OK);
    }
}
