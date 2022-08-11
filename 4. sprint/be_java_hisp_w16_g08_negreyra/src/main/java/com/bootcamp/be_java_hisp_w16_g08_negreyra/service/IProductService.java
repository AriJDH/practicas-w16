package com.bootcamp.be_java_hisp_w16_g08_negreyra.service;

import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PromoPostAmmountDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PromoPostOfUserDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PromoProductPostDto;

public interface IProductService {

    void publishPost(PostDto post);

    void publishDiscountPost(PromoProductPostDto pdDto);

    PromoPostAmmountDto getPromoPostAmmount(int userId);
    PromoPostOfUserDto ListPromoPostOfVendor(int vendorId);
}
