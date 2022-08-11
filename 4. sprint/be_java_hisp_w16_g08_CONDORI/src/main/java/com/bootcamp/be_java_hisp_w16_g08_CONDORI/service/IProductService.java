package com.bootcamp.be_java_hisp_w16_g08_CONDORI.service;

import com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response.PostPromotionCountDTO;
import com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response.PromoPostDto;

public interface IProductService {

    void publishPost(PostDto post);

    void publishPromoPost(PromoPostDto post);


}
