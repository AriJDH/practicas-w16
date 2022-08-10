package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;

import java.util.List;

public interface ICreateService {
    List<UserDTO> postData(List<UserDTO> userDTOList);

}
