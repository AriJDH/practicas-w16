package com.bootcamp.be_java_hisp_w16_g7_espitia.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    private String title;
    private String message;
}
