package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.FollowersCountDTO;
import com.example.be_java_hisp_w16_g09.dto.FollowersDtoResponse;
import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import com.example.be_java_hisp_w16_g09.dto.UserFollowedDto;
import com.example.be_java_hisp_w16_g09.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> US001(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(new MessageDto("User " + userIdToFollow + " followed successfully"), HttpStatus.OK);
    }
    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> US002(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.followerCount(userId), HttpStatus.OK);
    }
    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @GetMapping( "/users/{userId}/followers/list")
    public ResponseEntity<FollowersDtoResponse> US003(@PathVariable Integer userId, @RequestParam(required = false) String order){
        if (order != null)
            return new ResponseEntity<>(userService.orderByName(userId,order),HttpStatus.OK);
        else
            return new ResponseEntity<>(userService.getAllFollowers(userId), HttpStatus.OK);
    }
    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> US004(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null)
            return new ResponseEntity<>(userService.orderByNameFollowed(userId,order),HttpStatus.OK);
        else
            return new ResponseEntity<>(userService.getUsersFollowedBySellers(userId),HttpStatus.OK);
    }
    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDto> US007(@PathVariable int userId,@PathVariable int userIdToUnfollow){
        userService.unfollow(userId,userIdToUnfollow);
        return new ResponseEntity<>(new MessageDto("User "+userId+" unfollow "+userIdToUnfollow),HttpStatus.OK );
    }
}
