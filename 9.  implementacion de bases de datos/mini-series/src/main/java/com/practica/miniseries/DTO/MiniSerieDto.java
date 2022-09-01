package com.practica.miniseries.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerieDto {
    private String name;
    private Double rating;
    private Integer amount_of_awards;
}
