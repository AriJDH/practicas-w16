package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.*;

import java.util.List;

public interface IProductService {
    RecentPostsDTO recentPost(int idUser, String order);

    List<ResponsePostDTO> orderByDateAsc(List<ResponsePostDTO> postList);

    List<ResponsePostDTO> orderByDateDes(List<ResponsePostDTO> postList);

    ApiResponseDto createPost(PostDTO postDto);

    PromotionProductDTO getPromotionProducts(int id);

    ApiResponseDto createPromotionPost(PromoDTO postDto);


}
