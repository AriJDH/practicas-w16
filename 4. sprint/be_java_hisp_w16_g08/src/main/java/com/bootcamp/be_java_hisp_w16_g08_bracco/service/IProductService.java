package com.bootcamp.be_java_hisp_w16_g08_bracco.service;

import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PromoDto;

public interface IProductService {

    void publishPost(PostDto post);
    void publishPromoPost (PromoDto promoDto);
}
