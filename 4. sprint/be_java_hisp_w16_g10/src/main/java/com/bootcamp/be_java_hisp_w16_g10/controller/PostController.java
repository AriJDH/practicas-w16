package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PromoProductCountResDTO;
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
    public ResponseEntity<?> US0010(@RequestBody PostPromoReqDTO promoReqDTO){
        postService.save(promoReqDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count{user_id}")
    public ResponseEntity<PromoProductCountResDTO> US0011(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.promoProductCount(user_id),HttpStatus.OK);
    }

    @GetMapping("/promo-post/list{user_id}")
    public ResponseEntity<List<PostPromoResDTO>> US0012(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.listPostPromo(user_id),HttpStatus.OK);
    }
}
