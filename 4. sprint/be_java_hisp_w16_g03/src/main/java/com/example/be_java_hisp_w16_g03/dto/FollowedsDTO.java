package com.example.be_java_hisp_w16_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedsDTO {
    private Integer userId;
    private String userName;
    private List<UserDTO> userDtoList;
}
