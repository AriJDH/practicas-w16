package com.bootcamp.practico.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePersonajeDto {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
