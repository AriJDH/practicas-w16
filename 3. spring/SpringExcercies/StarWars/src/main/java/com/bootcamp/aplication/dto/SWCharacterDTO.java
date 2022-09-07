package com.bootcamp.aplication.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SWCharacterDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}
