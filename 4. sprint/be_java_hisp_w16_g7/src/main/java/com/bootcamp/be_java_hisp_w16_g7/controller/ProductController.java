package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g7.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService iProductService;
    @Autowired
    IUserService iUserService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/post")
    public ResponseEntity<ApiResponseDto> createPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iProductService.createPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> recentPost(@PathVariable int userId){
        return new ResponseEntity<>(iUserService.recentPost(userId), HttpStatus.OK);
    }
}
