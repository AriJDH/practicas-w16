package com.bootcamp.be_java_hisp_w16_g01_Morales.repository;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.CountPromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.PromoPost;

import java.util.List;

public interface IPromoPostRepository {
    int CreatePromoPost(PromoPost promoPost);

    List<PromoPost> getPromoPostsByUserId(int userId);

    CountPromoPostDTO countPromoPost(int userId);
}
