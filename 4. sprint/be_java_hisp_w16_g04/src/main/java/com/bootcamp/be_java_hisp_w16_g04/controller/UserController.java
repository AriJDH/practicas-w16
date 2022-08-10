package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;

import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<ResponseFollowersListDTO> Followerslist(@PathVariable int userId, @RequestParam Optional <String> order){
        return new ResponseEntity<>(iUserService.getListFollowersById(userId, order.orElse("")), HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable Integer userId) {
        UserFollowersCountDTO result = iUserService.followersCount(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> orderListUserFollowed(@PathVariable Integer userId, @RequestParam Optional <String> order){
        return new ResponseEntity<> (iUserService.orderListUserFollowed(userId, order.orElse("")), HttpStatus.OK);
    }
}
