package com.bootcamp.practico.dto;

import com.bootcamp.practico.entity.Personaje;
import lombok.Data;

@Data
public class RequestPersonajeDTO {


    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;


}
