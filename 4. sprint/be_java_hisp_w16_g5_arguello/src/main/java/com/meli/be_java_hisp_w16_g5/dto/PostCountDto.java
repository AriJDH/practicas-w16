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
//Clase que contiene la estructura que se devuelve para ver la cantidad de productos en promocion
public class PostCountDto {
    private int userID;
    private String userName;
    private int promoProductsCount;
}
