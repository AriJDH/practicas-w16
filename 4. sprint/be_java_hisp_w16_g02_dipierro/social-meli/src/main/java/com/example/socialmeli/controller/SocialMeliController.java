package com.example.socialmeli.controller;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.service.IPostService;
import com.example.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SocialMeliController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IPostService postService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> addFollower(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        userService.addFollower(userId,userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDto> getFollowersCountByUserId(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getFollowersCountByUserId(userId),HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> removeFollower(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        userService.removeFollower(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDto> getFollowersListByUserId(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(userService.getFollowersListByUserId(userId,order),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDto> getFollowedListByUserId(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(userService.getFollowedListByUserId(userId,order),HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<Void> addPost(@RequestBody PostDto post){
        postService.addPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListLastTwoWeeksDto> getFollowedPostLastTwoWeeks(@PathVariable int userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(postService.getFollowedPostListLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<Void> addPostWithPromotion(@RequestBody PostWithPromotionDto postWithPromotionDto){
        postService.addPostWithPromotion(postWithPromotionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<ProductWithPromotionCountDto> getProductWithPromotionCount(@RequestParam int userId){
        return new ResponseEntity<>(userService.getProductWithPromotionCount(userId), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<ProductWithPromotionListDto> getProductWithPromotionList(@RequestParam int userId){
        return new ResponseEntity<>(userService.getProductWithPromotionList(userId), HttpStatus.OK);
    }
}
