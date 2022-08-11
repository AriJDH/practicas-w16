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

    @ApiOperation(value = "Seguir vendedor", notes = "Poder realizar la acción de “Follow” (seguir) a un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendedor seguido correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.addFollower(userId, userIdToFollow),HttpStatus.OK);
    }

    @ApiOperation(value = "Dejar de seguir vendedor", notes = "Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vendedor dejado de seguir correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }

    @ApiOperation(value = "¿Quién me sigue?", notes = "Obtener un listado de todos los usuarios que siguen a un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Seguidores obtenidos correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> getFollowers(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(userService.getFollowers(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "¿A quién sigo?", notes = "Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Seguidores obtenidos correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable int userId, @RequestParam String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }


    @ApiOperation(value = "¿Cuántos me siguen?", notes = "Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Seguidores obtenidos correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getCantFollowers(userId), HttpStatus.OK);
    }

}
