package com.bootcamp.be_java_hisp_w16_g08_diaz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionApiDto {
    private String title;
    private String message;


}
