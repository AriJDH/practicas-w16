package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.ResponseUserInformationDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.ResponseVendorsFollowedDto;

import java.util.List;

public interface IUserService {
    ResponseVendorsFollowedDto getVendorsFollowedByUser(int userId);
}
