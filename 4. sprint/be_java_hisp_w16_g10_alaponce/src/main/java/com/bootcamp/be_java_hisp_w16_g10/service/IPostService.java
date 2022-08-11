package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PromoProductCountResDTO;

import java.util.List;

public interface IPostService {
    PostResDTO findById(Integer id);

    List<PostResDTO> findAll();

    List<PostResDTO> findByUserId(Integer userID);

    void save(PostReqDTO postReqDTO);

    PostListResDTO listFollowersPosts(Integer userId, String order);

    PromoProductCountResDTO promoProductCount(Integer user_id);

    List<PostPromoResDTO> listPostPromo(Integer user_id);
}
