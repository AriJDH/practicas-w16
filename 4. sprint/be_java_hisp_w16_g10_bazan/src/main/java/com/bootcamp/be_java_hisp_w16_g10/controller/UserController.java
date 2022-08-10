package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.service.IService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private IService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResDTO>> findAll() {
        return new ResponseEntity(this.userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity US001(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        this.userService.follow(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountResDTO> US002(@PathVariable Integer userId){
      return new ResponseEntity<>(this.userService.countFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersListResDTO> US003(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.userService.listFollowers(userId, order.orElse(null)),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedListResDTO> US004(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.userService.listFollowed(userId, order.orElse(null)), HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> US005(@RequestBody PostReqDTO postReqDTO){
        userService.save(postReqDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostResDTO>> US006(@PathVariable Integer userId,  @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.userService.listFollowersPosts(userId, order.orElse(null)), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity US007(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        this.userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public void US0010(){

    }

    @GetMapping("/products/promo-post/count?user_id={userId}")
    public void US0011(){

    }

    @GetMapping("/products/promo-post/list?user_id={userId}")
    public void US0012(){

    }
}
