package com.example.be_java_hisp_w16_g03.utils;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;

public class Mapper {

    public static Post promoPostDtoToEntity(PromoPostDTO promoDto) {
        return Post.builder()
                .userId(promoDto.getUserId())
                .date(promoDto.getDate())
                .price(promoDto.getPrice())
                .product(Product.builder().
                        productId(promoDto.getProduct().getProductId())
                        .brand(promoDto.getProduct().getBrand())
                        .color(promoDto.getProduct().getColor())
                        .type(promoDto.getProduct().getType())
                        .notes(promoDto.getProduct().getNotes())
                        .productName(promoDto.getProduct().getProductName())
                        .build())
                .category(promoDto.getCategory())
                .price(promoDto.getPrice())
                .hasPromo(promoDto.isHasPromo())
                .discount(promoDto.getDiscount()).build();
    }

    public static Post postDtoToEntity(PostDTO postDto) {
        return Post.builder()
                .userId(postDto.getUserId())
                .date(postDto.getDate())
                .price(postDto.getPrice())
                .product(Product.builder().
                        productId(postDto.getProduct().getProductId())
                        .brand(postDto.getProduct().getBrand())
                        .color(postDto.getProduct().getColor())
                        .type(postDto.getProduct().getType())
                        .notes(postDto.getProduct().getNotes())
                        .productName(postDto.getProduct().getProductName())
                        .build())
                .category(postDto.getCategory())
                .price(postDto.getPrice()).build();
    }

    public static PromoPostDTO promoPostToDto(Post post) {
        return PromoPostDTO.builder()
                .userId(post.getUserId())
                .date(post.getDate())
                .price(post.getPrice())
                .product(ProductDTO.builder().
                        productId(post.getProduct().getProductId())
                        .brand(post.getProduct().getBrand())
                        .color(post.getProduct().getColor())
                        .type(post.getProduct().getType())
                        .notes(post.getProduct().getNotes())
                        .productName(post.getProduct().getProductName())
                        .build())
                .category(post.getCategory())
                .price(post.getPrice())
                .hasPromo(post.isHasPromo())
                .discount(post.getDiscount())
                .build();
    }
}
