package com.bootcamp.be_java_hisp_w16_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVendorsFollowedDto {
    private int userId;
    private String userName;
    private List<ResponseUserInformationDto> followed;
}
