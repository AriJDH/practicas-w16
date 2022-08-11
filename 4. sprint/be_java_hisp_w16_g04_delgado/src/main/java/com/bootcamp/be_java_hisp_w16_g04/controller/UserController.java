package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserFollowersCountDTO;

import java.util.Optional;

/**
 * Service in charge of user-related functionalities
 */
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  IUserService iUserService;

  /**
   * Method to get the list of my followers
   * @param userId Current user id
   * @param order Order in which the list will be submitted
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("{userId}/followers/list")
  public ResponseEntity<ResponseFollowersListDTO> Followerslist(@PathVariable int userId, @RequestParam Optional<String> order) {
    return new ResponseEntity<>(iUserService.getListFollowersById(userId, order.orElse("")), HttpStatus.OK);
  }

  /**
   * Method used to obtain the number of users followers
   * @param userId Current user id
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/{userId}/followers/count")
  public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable Integer userId) {
    UserFollowersCountDTO result = iUserService.followersCount(userId);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  /**
   * Method to obtain the number of users that I follow
   * @param userId Current user id
   * @param order Order in which the list will be submitted
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/{userId}/followed/list")
  public ResponseEntity<UserFollowedDTO> orderListUserFollowed(@PathVariable Integer userId, @RequestParam Optional<String> order) {
    return new ResponseEntity<>(iUserService.orderListUserFollowed(userId, order.orElse("")), HttpStatus.OK);
  }



}
