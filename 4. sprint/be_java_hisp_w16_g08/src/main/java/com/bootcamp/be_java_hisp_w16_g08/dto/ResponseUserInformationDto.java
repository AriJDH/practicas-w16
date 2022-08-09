package com.bootcamp.be_java_hisp_w16_g08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserInformationDto {
    private int userId;
    private String userName;
}
