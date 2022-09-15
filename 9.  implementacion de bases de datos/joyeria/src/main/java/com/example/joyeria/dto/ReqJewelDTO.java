package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqJewelDTO {
    private String name;
    private String material;
    private Integer weight;
    private String particularity;
    private Boolean hasStone;
}
