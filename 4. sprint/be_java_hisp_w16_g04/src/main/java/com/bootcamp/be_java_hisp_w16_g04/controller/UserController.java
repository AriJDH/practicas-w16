package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<ResponseFollowersListDTO> Followerslist(@PathVariable int userId){
        return new ResponseEntity<>(iUserService.getListFolloersById(userId), HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable Integer userId) {
        UserFollowersCountDTO result = iUserService.followersCount(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/{userId}/followed/list")

    public ResponseEntity<UserFollowedDTO> listUserFollowed(@PathVariable Integer userId){
        return new ResponseEntity<> (iUserService.listUserFollowed(userId), HttpStatus.OK);
    }

}
