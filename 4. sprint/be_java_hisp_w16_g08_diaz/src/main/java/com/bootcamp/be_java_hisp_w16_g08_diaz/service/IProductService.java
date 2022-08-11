package com.bootcamp.be_java_hisp_w16_g08_diaz.service;

import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.request.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.response.ResponsePromoCounter;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.response.ResponsePromoPostFromUserDto;

public interface IProductService {

    void publishPost(PostDto post);

    void publishPromoPost(PromoPostDto promoPost);

    ResponsePromoCounter countPromoPost(int userId);

    ResponsePromoPostFromUserDto getPromoPostFromUser(int userId);
}
