package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.request.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.ResponsePromoCounter;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.ResponsePromoPostFromUserDto;

public interface IProductService {

    void publishPost(PostDto post);

    void publishPromoPost(PromoPostDto promoPost);

    ResponsePromoCounter countPromoPost(int userId);

    ResponsePromoPostFromUserDto getPromoPostFromUser(int userId);
}
