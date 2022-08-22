package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;

import java.util.List;

public interface IPostService {
    PostResDTO findById(Integer id);

    List<PostResDTO> findAll();

    List<PostResDTO> findByUserId(Integer userID);

    void save(PostReqDTO postReqDTO);
    void save(PostPromoReqDTO postPromoReqDTO);
    PostListResDTO listFollowersPosts(Integer userId, String order);
    PostPromoListResDTO listPromoPost(Integer userId);
    List<PostPromoListResDTO> listPromoPost();
    PostPromoCountResDTO countPromoPost(Integer userId);
    PostPromoCountResDTO maxCountUserPromoPost();
}
