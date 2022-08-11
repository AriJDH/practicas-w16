package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PromoPostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> US0010(@RequestBody PromoPostReqDTO promoPostReqDTO){
        postService.save(promoPostReqDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
     //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
     @GetMapping("/promo-post/count/{userId}")
     public ResponseEntity<PromoCountResDTO> US0011(@PathVariable Integer userId){
         return new ResponseEntity<>(this.postService.countPromos(userId),HttpStatus.OK);
     }
    
    //US 0012: Obtener un listado de todos los productos de una cierta categoria de un vendedor y devolverlos.
    @GetMapping("/promo-post/list/{userId}/{category}")
    public ResponseEntity<PostListResDTO> US0012(@PathVariable Integer userId, @PathVariable Integer category){
        return new ResponseEntity<>(this.postService.listCategoryPosts(userId,category),HttpStatus.OK);
    }
}
