package com.bootcamp.be_java_hisp_w16_g01_Morales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUnfollowDTO {
    protected String status;
    protected String message;
}
