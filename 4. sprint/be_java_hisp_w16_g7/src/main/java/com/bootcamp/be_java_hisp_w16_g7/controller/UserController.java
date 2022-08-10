package com.bootcamp.be_java_hisp_w16_g7.controller;


import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity(userService.follow(userId, userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity(userService.unfollow(userId, userIdToUnfollow));
    }

    @Operation(summary = "Get list of followed by given user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List given"),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
    })
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseUserFollowedDTO> getUserFollowedList(
            @Parameter(description = "User id") @PathVariable int userId,
            @Parameter(description = "Order query (name_asc, name_desc)") @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getUserFollowedList(userId, order), HttpStatus.OK);

    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersSellersDTO> getSellersFollowers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getSellersFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> getFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);

    }
}
