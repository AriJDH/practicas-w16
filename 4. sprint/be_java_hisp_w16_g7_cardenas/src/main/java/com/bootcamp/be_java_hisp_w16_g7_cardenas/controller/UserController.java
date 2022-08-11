package com.bootcamp.be_java_hisp_w16_g7_cardenas.controller;


import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.FollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.service.IUserService;
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

    @Operation(summary = "Follow an user")
    @Parameter(name = "userId", description = "Id of user making the action")
    @Parameter(name = "userIdToFollow", description = "Id of user to be followed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User followed"),
            @ApiResponse(responseCode = "400", description = "User to follow is not a seller or User is already being followed"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity(userService.follow(userId, userIdToFollow));
    }

    @Operation(summary = "Unfollow an user")
    @Parameter(name = "userId", description = "Id of user making the action")
    @Parameter(name = "userIdToUnfollow", description = "Id of user to be unfollowed")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User unfollowed"),
            @ApiResponse(responseCode = "400", description = "User is not being followed"),
            @ApiResponse(responseCode = "404", description = "User not found")})
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
            @Parameter(description = "Optional. Order query (name_asc, name_desc)") @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getUserFollowedList(userId, order), HttpStatus.OK);

    }

    @Operation(summary = "Get a specific user and their followers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "User isn't a seller / Unknown query", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)})
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersSellersDTO> getSellersFollowers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getSellersFollowers(userId, order), HttpStatus.OK);
    }

    @Operation(summary = "Get count of users who follow a seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object given"),
            @ApiResponse(responseCode = "400", description = "User is not a seller"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> getFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);

    }
}
