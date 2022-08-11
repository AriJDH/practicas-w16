package com.bootcamp.be_java_hisp_w16_g10_Lamela.controller;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.request.PostReqPromoDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostPromoListResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.service.IPostService;
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

    @PostMapping("/post")
    public ResponseEntity<?> US005(@RequestBody PostReqDTO postReqDTO){
        this.postService.save(postReqDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResDTO> US006(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.postService.listFollowersPosts(userId, order.orElse(null)), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<HttpStatus>  US0010(@RequestBody PostReqPromoDTO postReqPromoDTO){
        this.postService.saveWithPromo(postReqPromoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResDTO> US0011(@RequestParam("userId") Integer userId){
        PostPromoCountResDTO productsWithPromo = this.postService.countPostsWithPromo(userId);
        return new ResponseEntity<>(productsWithPromo, HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListResDTO> US0012(@RequestParam("userId") Integer userId){
        PostPromoListResDTO productsWithPromo = this.postService.listPostsWithPromo(userId);
        return new ResponseEntity<>(productsWithPromo, HttpStatus.OK);
    }
}
