package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqUpdateJewelDTO {
    private String name;
    private String material;
    private Integer weight;
    private String particularity;
    private Boolean hasStone;
    private Boolean isSold;
}
