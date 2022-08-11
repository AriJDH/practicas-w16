package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.PromotedPostDTO;
import com.example.be_java_hisp_w16_g09.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class PostController {

    @Autowired
    IPostService postService;

    //US 0005:
    @PostMapping("/post")
    public void createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
    }

    //US 0006:
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> getRecentPostsOfSellersFollowedByUserWith(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null)
            return new ResponseEntity<>(postService.orderByDate(userId,order),HttpStatus.OK);
        else
            return ResponseEntity.ok(postService.getRecentPostsOfSellersFollowedByUserWith(userId));
    }

    //US 0010:
    @PostMapping("/promo-post")
    public ResponseEntity createPromotedPost(@RequestBody PromotedPostDTO promotedPostDTO){
        postService.createPromotedPost(promotedPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDto("Promo post was created successfully"));
    }

    //US 0011:
    @GetMapping (path = "/promo-post/count")
    public ResponseEntity amountOfPromoPostsPublishedByUserWith(@RequestParam int user_id) {
        return ResponseEntity.ok(postService.amountOfPromoPostsPublishedByUserWith(user_id));
    }

    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping(path = "/promo-post/list")
    public ResponseEntity getPromotedPostsPublishedByUserWith(@RequestParam int user_id) {
        return ResponseEntity.ok(postService.getPromotedPostsOfUser(user_id));
    }
}
