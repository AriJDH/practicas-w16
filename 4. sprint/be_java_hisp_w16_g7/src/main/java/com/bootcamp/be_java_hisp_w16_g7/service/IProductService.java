package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;

public interface IProductService {

    ApiResponseDto createPost(PostDTO postDto);
}
