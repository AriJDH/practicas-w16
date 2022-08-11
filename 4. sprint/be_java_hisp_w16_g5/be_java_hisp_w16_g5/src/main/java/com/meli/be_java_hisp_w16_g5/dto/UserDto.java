package com.meli.be_java_hisp_w16_g5.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
/**
 * Clase, estructura para mostrar la cantidad de seguidores que tiene un usuario
 */
public class UserDto {

    private int userID;
    private String userName;
    private int followersCount;

}
