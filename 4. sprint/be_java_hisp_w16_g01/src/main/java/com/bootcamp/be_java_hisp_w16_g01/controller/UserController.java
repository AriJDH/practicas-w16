package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    protected IUserService userService;

    @ApiOperation(value = "Follow", notes = "Poder realizar la acción de “Follow” (seguir) a un determinado vendedor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.addFollower(userId, userIdToFollow),HttpStatus.OK);
    }

    @ApiOperation(value = "Unfollow", notes = "Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowDto> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @ApiOperation(value = "Followers List", notes = "Obtener un listado de todos los usuarios que siguen a un determinado vendedor" +
            " ¿Quién me sigue? y Ordenamiento alfabético ascendente y descendente")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDto> getFollowers(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(userService.getFollowers(userId, order), HttpStatus.OK);
    }


    @ApiOperation(value = "Followed List", notes = "Obtener un listado de todos los vendedores a los cuales sigue un determinado " +
            "usuario ¿A quién sigo? y Ordenamiento alfabético ascendente y descendente")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> getFollowed(@PathVariable int userId, @RequestParam String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }


    @ApiOperation(value = "Followers Count", notes = "Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getCantFollowers(userId), HttpStatus.OK);
    }

}
