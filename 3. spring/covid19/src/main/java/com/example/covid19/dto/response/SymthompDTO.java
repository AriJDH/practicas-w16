package com.example.covid19.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymthompDTO {
    private Integer code;
    private String name;
    private Integer levelSeverity;
}
