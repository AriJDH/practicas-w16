package com.example.socialmeli2.controller;

import com.example.socialmeli2.dto.UserFollowedListDto;
import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.dto.UserFollowersListDto;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> addFollower(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        userService.addFollower(userId,userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDto> getFollowersCountByUserId(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getFollowersCountByUserId(userId),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> removeFollower(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        userService.removeFollower(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDto> getFollowersListByUserId(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(userService.getFollowersListByUserId(userId,order),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDto> getFollowedListByUserId(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(userService.getFollowedListByUserId(userId,order),HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<User> getByID(@RequestParam Integer userId){
        return new ResponseEntity<>(userService.getById(userId),HttpStatus.OK);
    }
}
