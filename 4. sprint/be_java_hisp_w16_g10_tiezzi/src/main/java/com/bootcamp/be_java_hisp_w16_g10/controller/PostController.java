package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.IPostService;
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

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/post")
    public ResponseEntity<?> US005(@RequestBody PostReqDTO postReqDTO){
        this.postService.save(postReqDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResDTO> US006(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.postService.listFollowersPosts(userId, order.orElse(null)), HttpStatus.OK);
    }

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/promo-post")
    public ResponseEntity<?> US0010(@RequestBody PostPromoReqDTO postPromoReqDTO){
        this.postService.save(postPromoReqDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResDTO> US0011(@RequestParam(name = "user_id") Optional<Integer> userId){
        return new ResponseEntity<>(this.postService.countPromoPost(userId.orElse(null)), HttpStatus.OK);
    }

    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListResDTO> US0012(@RequestParam(name = "user_id") Optional<Integer> userId){
        return new ResponseEntity<>(this.postService.listPromoPost(userId.orElse(null)), HttpStatus.OK);
    }

    //US 0013: Obtener un listado con todos los productos en promocion por vendedor
    @GetMapping("/promo-post/list/all")
    public ResponseEntity<List<PostPromoListResDTO>> US0013(){
        return new ResponseEntity<>(this.postService.listPromoPost(), HttpStatus.OK);
    }

    //Us 0014: Obtener el usuario con más productos en promocion y su cantidad.
    @GetMapping("/promo-post/user/max")
    public ResponseEntity<PostPromoCountResDTO> US0014(){
        return new ResponseEntity<>(this.postService.maxCountUserPromoPost(), HttpStatus.OK);
    }
}
