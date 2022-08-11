package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserPromoCountDto;

import java.util.List;

public interface IProductService {

    void publishPost(PostDto post);

    void publishPromoPost(PromoPostDto promoPostDto);

    List<PromoPostDto> getPromoPostByUserId(int userId);

    UserPromoCountDto getUserPromoCount(int userId);
}
