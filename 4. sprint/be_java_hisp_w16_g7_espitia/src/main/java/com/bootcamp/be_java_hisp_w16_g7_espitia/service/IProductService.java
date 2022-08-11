package com.bootcamp.be_java_hisp_w16_g7_espitia.service;

import com.bootcamp.be_java_hisp_w16_g7_espitia.dto.*;

import java.util.List;

public interface IProductService {
    RecentPostsDTO recentPost(int idUser, String order);

    List<ResponsePostDTO> orderByDateAsc(List<ResponsePostDTO> postList);

    List<ResponsePostDTO> orderByDateDes(List<ResponsePostDTO> postList);

    ApiResponseDto createPost(PostDTO postDto);

    ApiResponseDto createPromoPost(PromoPostDTO promoPostDTO);

    ResponsePromoPostCountDTO countPromoPostByUser(int userId);

    ResponsePomoPostListDTO listPromoPostByUser(int userId);

}
