package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.*;

public interface ISocialMeliServiceE3 {

    void createPost(RequestPostDTO requestPostDTO);

    void createPostPromo(RequestPostPromoDTO requestPostPromotDTO);

    ResponsePostDTO getAllPost(int userId);

    ResponsePostDTO getAllPost(int userId, String Order);

    ResponsePostPromoDTO countAllPostPromo(int userId);

   /* ResponseDTO deletedPostPromo(int userId);*/

}
