package com.bootcamp.be_java_hisp_w16_g01_Morales.controller;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.CountPromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.PromoPost;
import com.bootcamp.be_java_hisp_w16_g01_Morales.service.IPromoPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class PromoPostController {

    @Autowired
    private IPromoPostService promoPostService;
    @ApiOperation(value = "US 10 - Llevar a cabo la publicación de un nuevo producto en promoción\n",
            notes = "Se crea un nuevo post de un producto con descuento.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/promo-post")
    public ResponseEntity<Integer> createPromoPost(@RequestBody PromoPostDTO promoPostDTO){
        return new ResponseEntity<>(promoPostService.createPromoPost(promoPostDTO), HttpStatus.OK);
    }
    @ApiOperation(value = "US 11 - Obtener la cantidad de productos en promoción de un determinado vendedor\n",
            notes = "Arroja la cantidad de productos en promocion de un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/count{userId}")
    public ResponseEntity<CountPromoPostDTO> getPromoCount(@RequestParam int userId){
        return  new ResponseEntity<>(promoPostService.countPromoPost(userId),HttpStatus.OK);
    }
    @ApiOperation(value = "US 12 - Obtener un listado de todos los productos en promoción de un determinado vendedor\n",
            notes = "Arroja un listado con los productos en promocion que tiene asociado un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/list{userId}")
    public ResponseEntity<List<PromoPost>> getPromoPost(@RequestParam int userId){
        return  new ResponseEntity<>(promoPostService.getPromoPostsByUserId(userId),HttpStatus.OK);
    }
}
