package com.bootcamp.be_java_hisp_w16_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUnfollowDto {
    protected String status;
    protected String message;
}
