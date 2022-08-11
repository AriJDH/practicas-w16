package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.ResponsePostDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
public class PostMapper {
    private ProductMapper productMapper = new ProductMapper();
    public ResponsePostDto toResponsePostDto(Post post){
        return new ResponsePostDto(post.getUserId(), post.getPostId(), post.getDate(), productMapper.toDto(post.getProduct()) ,
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }
}
