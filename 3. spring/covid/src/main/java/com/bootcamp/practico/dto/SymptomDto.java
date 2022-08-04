package com.bootcamp.practico.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SymptomDto {
    private String name;
    private int level;
}
