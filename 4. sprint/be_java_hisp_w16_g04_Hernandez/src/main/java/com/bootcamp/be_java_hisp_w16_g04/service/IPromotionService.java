package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;

public interface IPromotionService {
    ProductPromotionDTO productPromotion(Promotion promo);
}
