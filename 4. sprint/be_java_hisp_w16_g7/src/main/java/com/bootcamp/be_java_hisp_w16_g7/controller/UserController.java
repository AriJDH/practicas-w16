package com.bootcamp.be_java_hisp_w16_g7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity(userService.unfollow(userId, userIdToUnfollow));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseUserFollowedDTO> getUserFollowedList(@PathVariable int userId,
                                                                       @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getUserFollowedList(userId, order), HttpStatus.OK);
    }
}
