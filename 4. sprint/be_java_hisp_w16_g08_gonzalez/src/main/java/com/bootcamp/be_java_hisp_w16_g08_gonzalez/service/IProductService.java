package com.bootcamp.be_java_hisp_w16_g08_gonzalez.service;

import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.PostPromoCounterDTO;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.PostPromoDTO;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.ResponseProductPromoDTO;

public interface IProductService {

    void publishPost(PostDto post);
    void publishPostPromo(PostPromoDTO postPromo);
    PostPromoCounterDTO getProductsInPromo (int id);
    ResponseProductPromoDTO getAllProductsInPromo (int userId);

}
