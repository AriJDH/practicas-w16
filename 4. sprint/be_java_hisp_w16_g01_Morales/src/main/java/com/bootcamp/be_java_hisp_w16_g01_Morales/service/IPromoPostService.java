package com.bootcamp.be_java_hisp_w16_g01_Morales.service;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.CountPromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.PromoPost;

import java.util.List;

public interface IPromoPostService {
    int createPromoPost(PromoPostDTO promoPostDTO);

    List<PromoPost> getPromoPostsByUserId(int userId);

    CountPromoPostDTO countPromoPost(int userId);
}
