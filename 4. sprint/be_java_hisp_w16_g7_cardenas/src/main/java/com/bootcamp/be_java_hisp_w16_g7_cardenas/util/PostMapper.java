package com.bootcamp.be_java_hisp_w16_g7_cardenas.util;

import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.entity.Post;
import org.modelmapper.ModelMapper;

public class PostMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static ResponsePostDTO mapPostToDto(Post post) {
        ResponsePostDTO dto = mapper.map(post, ResponsePostDTO.class);
        if(post.isHasPromo())
            dto.setPrice(post.getPrice() * (1 - post.getDiscount()));
        return dto;
    }
}
