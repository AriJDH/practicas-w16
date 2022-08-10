package com.example.springstarwars.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;
}
