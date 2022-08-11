package com.bootcamp.be_java_hisp_w16_g10_Lamela.service;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.request.PostReqPromoDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostPromoListResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Post;

import java.util.List;

public interface IPostService {
    PostResDTO findById(Integer id);

    List<PostResDTO> findAll();

    List<PostResDTO> findByUserId(Integer userID);

    Post save(PostReqDTO postReqDTO);

    PostListResDTO listFollowersPosts(Integer userId, String order);
    void saveWithPromo(PostReqPromoDTO postReqPromoDTO);
    PostPromoCountResDTO countPostsWithPromo(Integer userId);
    PostPromoListResDTO listPostsWithPromo(Integer userId);
}
