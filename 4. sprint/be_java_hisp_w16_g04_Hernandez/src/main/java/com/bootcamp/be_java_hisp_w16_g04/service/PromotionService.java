package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g04.exception.ProductIlegalPromotion;
import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;
import com.bootcamp.be_java_hisp_w16_g04.repositories.IPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService{
    @Autowired
    IPromotionRepository ipromotionRepository;

    @Override
    public ProductPromotionDTO productPromotion(Promotion promo) {
        Boolean verifyPromotion = ipromotionRepository.verifyPromotion(promo);

        if (!verifyPromotion) {
            throw new ProductIlegalPromotion("The product is already on promotion");
        }

        ipromotionRepository.productPromotion(promo);
        return new ProductPromotionDTO("Successful promoted");
    }
}
