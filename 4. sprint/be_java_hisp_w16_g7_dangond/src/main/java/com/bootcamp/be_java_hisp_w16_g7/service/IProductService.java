package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;

import java.util.List;

public interface IProductService {
    RecentPostsDTO recentPost(int idUser, String order);

    List<ResponsePostDTO> orderByDateAsc(List<ResponsePostDTO> postList);

    List<ResponsePostDTO> orderByDateDes(List<ResponsePostDTO> postList);

    ApiResponseDto createPost(PostDTO postDto);
    ApiResponseDto postOfProductWithDiscount(PostDTO postDto);

}
