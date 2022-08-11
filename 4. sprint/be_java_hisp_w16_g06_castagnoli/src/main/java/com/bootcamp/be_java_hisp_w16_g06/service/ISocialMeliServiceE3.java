package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.RequestPostDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.RequestPostPromoDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponsePostPromoDto;

public interface ISocialMeliServiceE3 {

    void createPost(RequestPostDTO requestPostDTO);
    void createPostPromo(RequestPostPromoDTO requestPostDTO);

    ResponsePostDTO getAllPost(int userId);

    ResponsePostDTO getAllPost(int userId, String Order);
    ResponsePostPromoDto getAllPostPromo(int userId);

}
