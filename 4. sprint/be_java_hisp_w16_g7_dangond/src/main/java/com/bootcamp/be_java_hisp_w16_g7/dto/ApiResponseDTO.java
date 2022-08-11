package com.bootcamp.be_java_hisp_w16_g7.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDTO {
    private String title;
    private String message;
}
