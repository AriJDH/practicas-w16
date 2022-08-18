package com.bootcamp.be_java_hisp_w16_g7.dto;

import lombok.*;

import java.util.HashMap;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    private String title;
    private String message;
}
