package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class FollowerController {
  @Autowired
  IFollowerService ifollowerService;

  @PostMapping("/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<FollowUserDTO> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
    return new ResponseEntity<>(ifollowerService.followUser(userId, userIdToFollow), HttpStatus.OK);
  }

  @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<FollowUserDTO> unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
    return new ResponseEntity<>(ifollowerService.unFollowUser(userId, userIdToUnfollow), HttpStatus.OK);
  }


}
