package com.example.covid19.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SymthompReqDTO {
    private Integer code;
    private String name;
    private Integer levelSeverity;
}
