package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class FieldErrorDTO {
    private String name;
    private String error;
}
