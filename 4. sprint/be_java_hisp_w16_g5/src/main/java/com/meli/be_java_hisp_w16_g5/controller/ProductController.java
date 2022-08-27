package com.meli.be_java_hisp_w16_g5.controller;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoDiscountDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoProductsCounts;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.exceptions.NoPostException;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private IPostService postService;


    @PostMapping("/post")
    public ResponseEntity<PostDto> savePost(@RequestBody Post post) throws UserNotFoundException, ProducNotFoundException {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedProducts(@PathVariable int userId, @RequestParam Optional<String> order) throws UserNotFoundException, UnknownRequestException {
        return ResponseEntity.ok(postService.getFollowedProducts(userId, order.isPresent() ? order.get() : null));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PromoDiscountDto> savePostPromo(@RequestBody Post post) throws UserNotFoundException, ProducNotFoundException {
        return new ResponseEntity<>(postService.savePostDiscount(post), HttpStatus.OK);

    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoProductsCounts> getPromoCount(@RequestParam("user_id") int id) throws UserNotFoundException, NoPostException {
        return new ResponseEntity<>(postService.getPostDiscountCount(id), HttpStatus.OK);

    }
}
