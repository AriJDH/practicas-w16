package com.bootcamp.be_java_hisp_w16_g10.service;

import java.util.List;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqPromoDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductsPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.SellerPromoProductsListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.SellerPromoProductsResDTO;

public interface IPostService {
   PostResDTO findById(Integer id);

   List<PostResDTO> findAll();

   List<PostResDTO> findByUserId(Integer userID);

   void save(PostReqDTO postReqDTO);

   PostListResDTO listFollowersPosts(Integer userId, String order);

   void saveWithPromo(PostReqPromoDTO model);

   ProductsPromoCountResDTO countPromoProducts(Integer userId);

   SellerPromoProductsListResDTO listSellerPromoProducts(Integer userId);

   List<SellerPromoProductsResDTO> listSellerProductsPromoAll();

}
