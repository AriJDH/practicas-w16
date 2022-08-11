package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.RequestPostDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponsePostDTO;

public interface ISocialMeliServiceE3 {

    void createPost(RequestPostDTO requestPostDTO);

    ResponsePostDTO getAllPost(int userId);

    ResponsePostDTO getAllPost(int userId, String Order);

}
