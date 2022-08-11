package com.bootcamp.be_java_hisp_w16_g06.service.iservice;

import com.bootcamp.be_java_hisp_w16_g06.dto.*;

public interface ISocialMeliServiceE3 {

    void createPost(RequestPostDTO requestPostDTO);

    void createPostPromo(RequestPostPromoDTO requestPostDTO);

    ResponsePostDTO getAllPost(int userId);

    ResponsePostDTO getAllPost(int userId, String Order);

    ResponsePostPromoDto getSizePostPromo(int userId);
    ResponsePostAllPromoDto getAllPostPromo(int userId);

}
