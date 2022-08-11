package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
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
    public void US0010(){

    }

    @GetMapping("/promo-post/count?user_id={userId}")
    public void US0011(){

    }

    @GetMapping("/promo-post/list?user_id={userId}")
    public void US0012(){

    }
}
