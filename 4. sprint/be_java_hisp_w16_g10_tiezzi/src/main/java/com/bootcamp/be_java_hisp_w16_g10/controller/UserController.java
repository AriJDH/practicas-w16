package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    //US BONUS: traer todos los users
    @GetMapping()
    public ResponseEntity<List<UserResDTO>> findAll() {
        return new ResponseEntity(this.userService.findAll(), HttpStatus.OK);
    }

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity US001(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        this.userService.follow(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountResDTO> US002(@PathVariable Integer userId){
      return new ResponseEntity<>(this.userService.countFollowers(userId),HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListResDTO> US003(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.userService.listFollowers(userId, order.orElse(null)),HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListResDTO> US004(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.userService.listFollowed(userId, order.orElse(null)), HttpStatus.OK);
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity US007(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        this.userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }
}
