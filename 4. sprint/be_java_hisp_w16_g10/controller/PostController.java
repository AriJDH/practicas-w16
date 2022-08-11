package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqPromoDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductsPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.SellerPromoProductsListResDTO;
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
   public ResponseEntity<?> US005(@RequestBody PostReqDTO postReqDTO) {
      this.postService.save(postReqDTO);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("/followed/{userId}/list")
   public ResponseEntity<PostListResDTO> US006(@PathVariable Integer userId, @RequestParam Optional<String> order) {
      return new ResponseEntity<>(this.postService.listFollowersPosts(userId, order.orElse(null)), HttpStatus.OK);
   }

   @PostMapping("/promo-post")
   public ResponseEntity<?> US010(@RequestBody PostReqPromoDTO postReqPromoDTO) {
      this.postService.saveWithPromo(postReqPromoDTO);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("/promo-post/count")
   public ResponseEntity<ProductsPromoCountResDTO> US0011(@RequestParam Integer user_id) {
      return new ResponseEntity<>(this.postService.countPromoProducts(user_id), HttpStatus.OK);
   }

   @GetMapping("/promo-post/list")
   public ResponseEntity<SellerPromoProductsListResDTO> US0012(@RequestParam Integer user_id) {
      return new ResponseEntity<>(this.postService.listSellerPromoProducts(user_id), HttpStatus.OK);
   }

   @GetMapping("/promo-post/all24hs")
   public ResponseEntity<List<SellerPromoProductsListResDTO>> US0013() {
      return new ResponseEntity<>(this.postService.listSellerProductsPromoAll(), HttpStatus.OK);
   }

}
