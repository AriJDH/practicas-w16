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

/**
 * Service in charge of follower-related functionalities
 */
@RestController
@RequestMapping("users")
public class FollowerController {
  @Autowired
  IFollowerService ifollowerService;

  /**
   * Service that is responsible for receiving the id of the current user and the id of the user id to follow
   * @param userId Current user id
   * @param userIdToFollow Id of the user to follow
   * @return ResponseEntity with a DTO to give information to the user
   */
  @PostMapping("/{userId}/follow/{userIdToFollow}")
  public ResponseEntity<FollowUserDTO> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
    return new ResponseEntity<>(ifollowerService.followUser(userId, userIdToFollow), HttpStatus.OK);
  }

  /**
   * Service that is responsible for receiving the id of the current user and the id of the user id to un follow
   * @param userId Current user id
   * @param userIdToUnfollow Id of the user to un follow
   * @return ResponseEntity with a DTO to give information to the user
   */
  @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
  public ResponseEntity<FollowUserDTO> unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
    return new ResponseEntity<>(ifollowerService.unFollowUser(userId, userIdToUnfollow), HttpStatus.OK);
  }


}
