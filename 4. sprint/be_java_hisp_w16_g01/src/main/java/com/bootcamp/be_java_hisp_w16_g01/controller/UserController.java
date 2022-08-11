package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.service.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "US 01 - Seguir a un vendedor",
            notes = "Un comprador se registra como seguidor de un vendedor.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> addFollower(
            @PathVariable @ApiParam(value = "Id del usuario seguidor") int userId,
            @PathVariable @ApiParam(value = "Id del vendedor a seguir") int userIdToFollow){
        return new ResponseEntity<>(userService.addFollower(userId, userIdToFollow),HttpStatus.OK);
    }

    @ApiOperation(value = "US 02 - Cantidad de seguidores",
            notes = "Obtiene los datos de un vendedor y la cantidad de seguidores que tiene.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(
            @PathVariable @ApiParam(value = "Id del vendedor del que se quiere obtener la cantidad de seguidores") int userId){
        return new ResponseEntity<>(userService.getCantFollowers(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "US 03 - Listado seguidores",
            notes = "Lista los seguidores de un determinado vendedor.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> getFollowers(
            @PathVariable @ApiParam(value = "Id del vendedor del que se desea obtener los seguidores") int userId,
            @RequestParam(required = false) @ApiParam(value = "Orden de la lista (valores aceptados: name_desc, name_asc)") String order) {
        return new ResponseEntity<>(userService.getFollowers(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "US 04 - Listado seguidos",
            notes = "Lista los vendedores que sigue un determinado comprador.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(
            @PathVariable @ApiParam(value = "Id del usuario del que se desea obtener los vendedores que sigue") int userId,
            @RequestParam(required = false) @ApiParam(value = "Orden de la lista (valores aceptados: name_desc, name_asc)") String order){
        return new ResponseEntity<>(userService.getFollowed(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "US 07 - Dejar de seguir a un vendedor",
            notes = "Un comprador deja de seguir las publicaciones de un vendedor, se solicita el identificador de ambos usuarios.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserUnfollowDTO> unfollowUser(
            @PathVariable @ApiParam(value = "Id del usuario que dejara de seguir a un vendedor") int userId,
            @PathVariable @ApiParam(value = "Id del vendedor que dejara de ser seguido") int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }
}
