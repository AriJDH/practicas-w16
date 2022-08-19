package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g01.service.IPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @ApiOperation(value = "US 05 - Alta de publicacion",
            notes = "Da de alta una nueva publicación.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/post")
    public ResponseEntity<MessageDto> createPost(
            @RequestBody @ApiParam(value = "Datos de la publicacion y del producto a publicar por el vendedor") @Valid PostDto postDTO) {
        return new ResponseEntity<MessageDto>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "US 06 - Listado de publicaciones de los vendedores seguidos",
            notes = "Obtiene un listado de las publicaciones realizadas por los vendedores que el usuario sigue en las últimas dos semanas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPostsOrder(
            @PathVariable @ApiParam(value = "Usuario que sigue a los vendedores de los que se devolveran las publicaciones") @NotNull @Positive Integer userId,
            @RequestParam @ApiParam(value = "Orden de la lista (valores aceptados: date_desc, date_asc)") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

}
