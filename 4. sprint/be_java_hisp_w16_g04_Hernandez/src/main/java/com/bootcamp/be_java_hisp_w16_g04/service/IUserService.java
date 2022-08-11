package com.bootcamp.be_java_hisp_w16_g04.service;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;

public interface IUserService {
  ResponseFollowersListDTO getListFollowersById(Integer userId, String order);

  UserFollowersCountDTO followersCount(Integer userId);

  UserFollowedDTO orderListUserFollowed(Integer userId, String order);

  UserPromosCountDTO promosCount(Integer userId);

  PromotionDTO listProductsPromotion(Integer userId, String order);

}
