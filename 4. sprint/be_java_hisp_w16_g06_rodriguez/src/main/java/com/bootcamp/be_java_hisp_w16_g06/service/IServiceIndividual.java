package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.CountPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.ListProductDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.RequestPostPromotionDTO;


public interface IServiceIndividual {

    void registerPostPromotion(RequestPostPromotionDTO requestPostPromotionDTO);
    CountPromotionDTO getCountPromotionDTO(int userId);
    ListProductDTO getProductByCategory(int idCategory);

}
