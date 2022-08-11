package com.meli.be_java_hisp_w16_g5.controller;


import com.meli.be_java_hisp_w16_g5.dto.UserFollowerDto;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.service.IUserService;

import com.meli.be_java_hisp_w16_g5.dto.UserFollowedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

    /**
     * userService contiene los metodos necesarios para realizar las diferentes solicitudes existentes
     */
    @Autowired
    private IUserService userService;

    /**
     * US 0002: Metodo que obtiene el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     * @param userId
     * @return UserDto
     * @throws UserNotFoundException
     */
    @GetMapping("/{userid}/followers/count")
    public ResponseEntity getFollowersCount(@PathVariable("userid") int userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getCountFollows(userId));
    }

    /**
     * US 0004: Metodo que obtiene un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
     * @param userId
     * @param order
     * @return UserFollowedDto
     * @throws UserNotFoundException
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDto> getFollowedsList(@PathVariable("userId") int userId, @RequestParam(value = "order",required = false) String order) throws UserNotFoundException {
        return new ResponseEntity(userService.getFollowingSorted(userId,order),HttpStatus.OK);
    }

    /**
     * US 0003: Metodo que obtiene un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     * @param userId
     * @param order
     * @return UserFollowerDto
     * @throws UserNotFoundException
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDto> getFollowers(@PathVariable int userId, @RequestParam(value = "order",required = false) String order) throws UserNotFoundException{
        return new ResponseEntity<>(userService.getFollowersSorted(userId,order), HttpStatus.OK);
    };

    /**
     * US 0001: Metodo para poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * @param userId
     * @param userIdToFollow
     * @return UserFollowsDto
     * @throws UserNotFoundException
     */
    @PostMapping("/{userid}/follow/{userIdToFollow}")
    public ResponseEntity setUserFollowSeller(@PathVariable("userid") int userId, @PathVariable("userIdToFollow") int userIdToFollow ) throws UserNotFoundException {
        return ResponseEntity.ok(userService.setUserFollowSeller(userId,userIdToFollow));
    }

    /**
     * US 0007: Metodo para poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     * @param userId
     * @param userIdToFollow
     * @return UserFollowsDto
     * @throws UserNotFoundException
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity setUnfollowSeller(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int userIdToFollow ) throws UserNotFoundException {
        return ResponseEntity.ok(userService.setUnfollowUser(userId,userIdToFollow));
    }
}
