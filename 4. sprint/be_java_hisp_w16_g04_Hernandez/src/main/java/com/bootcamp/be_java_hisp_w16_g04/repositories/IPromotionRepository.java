package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;

import java.util.List;

public interface IPromotionRepository {
    void productPromotion(Promotion promo);
    Boolean verifyPromotion(Promotion promo);
    Long getPromoByUserId(Integer userId);
    List<Promotion> getListPromosByUserId(Integer userId);
}
