package com.bootcamp.practico.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RiskPersonDto {

    private String name;
    private String lastname;

}
