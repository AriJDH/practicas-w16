package com.bootcamp.be_java_hisp_w16_g01_rodriguez.controller;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.*;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.service.IPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @ApiOperation(value = "Alta de publicacion",
            notes = "Da de alta una nueva publicación.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/post")
    public ResponseEntity<MessageDTO> createPost(
            @RequestBody @ApiParam(value = "Datos de la publicacion y del producto a publicar por el vendedor") PostDTO postDTO) {
        return new ResponseEntity<MessageDTO>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Alta de publicacion en promo",
            notes = "Da de alta una nueva publicación en promo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> createPost(
            @RequestBody @ApiParam(value = "Datos de la publicacion y del producto a publicaren esta promo del vendedor") PromoPostDTO postDTO) {
        return new ResponseEntity<MessageDTO>(postService.createPromoPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Listado de publicaciones de los vendedores seguidos",
            notes = "Obtiene un listado de las publicaciones realizadas por los vendedores que el usuario sigue en las últimas dos semanas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDTO> getFollowedPostsOrder(
            @PathVariable @ApiParam(value = "Usuario que sigue a los vendedores de los que se devolveran las publicaciones") int userId,
            @RequestParam(required = false) @ApiParam(value = "Orden de la lista (valores aceptados: date_desc, date_asc)") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "Cantidad de publicaciones en promo por vendedor",
            notes = "Obtiene la cantidad de publicaciones en promoción de un determinado vendedor.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCount(
            @RequestParam @ApiParam(value = "Vendedor del cual quiero obtener la cantidad de publicaciones en promo") int user_Id) {
        return new ResponseEntity<>(postService.getPromoPostCount(user_Id), HttpStatus.OK);
    }

    @ApiOperation(value = "Listado de publicaciones por vendedor",
            notes = "Obtiene un listado de todos los productos en promoción de un determinado vendedor.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/list")
    public ResponseEntity<UserPromoPostsDTO> getUserPromoPostsDto(
            @RequestParam @ApiParam(value = "Vendedor del cual quiero obtener las publicaciones") int user_Id){
        return new ResponseEntity<>(postService.getUserPromoPosts(user_Id), HttpStatus.OK);
    }

    @ApiOperation(value = "Publicaciones con varios filtros", notes = "Permite obtener un listado de publicaciones filtrado de varias maneras.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/filtered-list")
    public ResponseEntity<List<PromoPostDTO>> getFilteredPosts(
            @RequestParam(required = false) @ApiParam(value = "Categoria de la publicacion") int category,
            @RequestParam(required = false) @ApiParam(value = "Tipo de producto") String type,
            @RequestParam(required = false) @ApiParam(value = "Marca del producto") String brand,
            @RequestParam(required = false) @ApiParam(value = "Precio minimo del rango seleccionado") double minPrice,
            @RequestParam(required = false) @ApiParam(value = "Precio maximo del rango seleccionado") double maxPrice,
            @RequestParam(required = false) @ApiParam(value = "Incluir productos en promo") boolean includePromo,
            @RequestParam(required = false) @ApiParam(value = "Busqueda por el nombre del producto") String search){
        return new ResponseEntity<>(postService.getFilteredPosts(category, type, brand, minPrice, maxPrice, includePromo, search), HttpStatus.OK);
    }
}
