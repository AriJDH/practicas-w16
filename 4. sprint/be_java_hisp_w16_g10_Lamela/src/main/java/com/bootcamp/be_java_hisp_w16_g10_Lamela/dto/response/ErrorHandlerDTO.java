package com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHandlerDTO {
    private Integer error;
    private String message;
}
